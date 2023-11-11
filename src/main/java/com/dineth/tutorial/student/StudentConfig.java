package com.dineth.tutorial.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student dineth = new Student(
                    "Dineth",
                    "dineth.hettiarachchi@gmail.com",
                    LocalDate.of(2000, 10, 11)
            );
            Student thisuru = new Student(
                    "Thisuru",
                    "thisuru@gmail.com",
                    LocalDate.of(2002, Month.JUNE,22)
            );
            repository.saveAll(
                    List.of(dineth,thisuru)
            );
        };
    }
}
