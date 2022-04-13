package com.example.demo.studnet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration   // also was been used insead of springbootapplication annotation
public class StudentConfigration {

    @Bean
        // so that this one run
    CommandLineRunner commandLineRunner(
            StudentRepository repository
    ) {
        return args -> {

            Student hosam = new Student(
                    "Hosam",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "Hosame321@gmail.com"
            );
            Student malik = new Student(
                    "Malikaj",
                    LocalDate.of(2001, Month.JANUARY, 5),
                    "MalikMohammed@gmail.com"
            );

            repository.saveAll(List.of(hosam, malik));

        };  // get this functoin to be excute after application be running
    }
}
