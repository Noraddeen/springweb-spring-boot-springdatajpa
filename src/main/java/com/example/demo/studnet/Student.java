package com.example.demo.studnet;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity(name = "Student")
@Table(
        name = "Student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
        }
)
class Student {
    @Id
    @SequenceGenerator(
            name = "studtent_seq",
            sequenceName = "student_seq",
            initialValue = 2,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )
    long Id;
    @Column(
            columnDefinition = "Text",
            nullable = false,
            updatable = true
    )
    String name;
    @Column(
            columnDefinition = "Date",
            nullable = false
    )
    LocalDate dob;
    @Column(
            columnDefinition = "Text",
            //  unique = true, not put it becouse it will overide the operate of unique with not understanded name of constration
            nullable = false
    )
    String email;
    @Transient
    private Integer age;


    public Student(long id, String name, LocalDate dob, String email) {
        Id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.setAge();

    }

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.setAge();
    }

    public Student() {

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(this.dob, currentDate).getYears();
    }

    public void setAge() {
        LocalDate currentDate = LocalDate.now();
        this.age = Period.between(this.dob, currentDate).getYears();
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
