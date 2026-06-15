package com.issam.teacher;

import com.issam.teacher.entities.Teacher;
import com.issam.teacher.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class TeacherMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository) {
        return args -> {
            teacherRepository.save(Teacher.builder()
                    .firstName("Issam")
                    .lastName("El Atlati")
                    .depCode("IT")
                    .build());

        };
    }
}
