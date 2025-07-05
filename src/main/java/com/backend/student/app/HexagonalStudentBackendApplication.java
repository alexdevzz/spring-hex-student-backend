package com.backend.student.app;

import com.backend.student.app.infrastructure.adapters.output.database.postgres.entity.StudentEntity;
import com.backend.student.app.infrastructure.adapters.output.database.postgres.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class HexagonalStudentBackendApplication implements CommandLineRunner {

    // only development ...
    private final StudentJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(HexagonalStudentBackendApplication.class, args);
    }

    // only development ...
    @Override
    public void run(String... args) throws Exception {
        List<StudentEntity> students = Arrays.asList(
                new StudentEntity(null, "Alex", "Pineda", "calle 1", 20),
                new StudentEntity(null, "Ramon", "Paz", "calle 2", 45),
                new StudentEntity(null, "Pedro", "Pascal", "calle 3", 36),
                new StudentEntity(null, "Silvo", "Rodriguez", "calle 7", 68)
        );
        repository.saveAll(students);
    }
}
