package com.example.demo.studnet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "now/")
public class StudentControler {

    @Autowired
    private final StudentService studentService;

    public StudentControler(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students")
    public List<Student> getStudents() {

        return studentService.getStudents();

    }

    @GetMapping("students/{id}")
    public Student getStudent(@PathVariable String id) {
        throw new IllegalStateException("No Student");
    }

    @DeleteMapping("delete/{studentId}")
    public void deleteStudent(@PathVariable long StudentId) {
        studentService.deleteStudent(StudentId);
    }

    @PostMapping("add")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping("update/{id}")
    public void updateStudent(@PathVariable Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(id, name, email);

    }
}
