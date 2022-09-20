package com.example.mongoDB.demo;

import com.example.mongoDB.demo.model.Address;
import com.example.mongoDB.demo.model.Gender;
import com.example.mongoDB.demo.model.Student;
import com.example.mongoDB.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Address address = new Address("Portugal", "3456", "Porto");
            String email = "maria@gmail.com";
            Student student = new Student(
                    "Maria",
                    "Mora",
                    email,
                    Gender.FEMALE,
                    address,
                    List.of("Computer Science", "Maths"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );
            repository.findStudentByEmail(email).ifPresentOrElse(s -> {
                        System.out.println(s + " already exists");
                    },
                    () -> {
                        System.out.println("Inserting student " + student);
                        repository.insert(student);
                    });
        };
    }
}
