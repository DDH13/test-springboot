package com.dineth.tutorial.university;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UniversityConfig {
    @Bean
    CommandLineRunner commandLineRunner2(UniversityRepository repository){
        return args -> {
            University marywood = new University(
                    "Marywood University",
                    "United States",
                    "US",
                    null,
                    List.of("http://www.marywood.edu"),
                    List.of("marywood.edu")
            );
            University lindenwood = new University(
                    "Lindenwood University",
                    "United States",
                    "US",
                    null,
                    List.of("http://www.lindenwood.edu/"),
                    List.of("lindenwood.edu")
            );
            University sullivan = new University(
                    "Sullivan University",
                    "United States",
                    "US",
                    null,
                    List.of("https://sullivan.edu/"),
                    List.of("sullivan.edu")
            );
            repository.saveAll(
                    List.of(marywood,lindenwood,sullivan)
            );
        };
    }
}
