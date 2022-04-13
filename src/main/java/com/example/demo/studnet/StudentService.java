package com.example.demo.studnet;

import com.example.demo.AOP.Loggable;
import com.example.demo.exeptionhundler.RequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {

        return studentRepository.findAll();
    }



    public void addNewStudent(Student student) {
        Optional<Student> studnetOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studnetOptional.isPresent()) {
            throw new RequestException("Email already excest");
        }
        this.studentRepository.save(student);
    }

    public Student getStudent(String studentId) {
        return this.studentRepository.findById(Long.parseLong(studentId)).orElse(null);
    }

    @Loggable
    public void deleteStudent(long studentId) {
        boolean isFound = studentRepository.existsById(studentId);
        if (isFound) {
            studentRepository.deleteById(studentId);
        } else {
            throw new RequestException("the student with id" + studentId + "not found");
        }
    }

    @Transactional   // for updating and persisting it :
//    Let's assume user A wants to transfer 100$ to user B. What happens is:
//    We decrease A's account by 100$
//    We add 100$ to B's account
//    Let's assume the exception is thrown after succeeding 1) and before executing 2).
//    Now we would have some kind of inconsistency because A lost 100$ while B got nothing.
//    Transactions means all or nothing. If there is an exception thrown somewhere in the method,
//    changes are not persisted in the database. Something called rollback happens.
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new RequestException("no student with given Id"));
        Optional.ofNullable(name)
                .filter(t -> t.length() > 0)
                .filter(t -> !(name.equals(student.getName())))    // f(f(x))
                .ifPresent((t) -> {
                    student.setName(t);
                });
        Optional<String> studentEmail = Optional.ofNullable(email)
                .filter(t -> t.length() > 0)
                .filter(t -> !(email.equals(student.getEmail())));
        if (studentEmail.isPresent()) {
            studentRepository.findStudentByEmail(email).ifPresentOrElse(
                    (t) -> {
                        throw new RequestException("email taken");
                    },
                    () -> {
                        student.setEmail(email);
                    }
            );
        }


    }
}
