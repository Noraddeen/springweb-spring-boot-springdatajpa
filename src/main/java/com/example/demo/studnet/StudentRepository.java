package com.example.demo.studnet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// is work as list
// all Quary operation should be sepersted from service only in data access layer
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "Select * from student s where s.email = ?1 ", nativeQuery = true)
    public Optional<Student> findStudentByEmail(String email);

}
