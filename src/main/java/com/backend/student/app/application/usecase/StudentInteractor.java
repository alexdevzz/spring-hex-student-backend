package com.backend.student.app.application.usecase;

import com.backend.student.app.application.ports.input.StudentServicePort;
import com.backend.student.app.application.ports.output.StudentPersistencePort;
import com.backend.student.app.domain.exception.StudentNotFoundException;
import com.backend.student.app.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentInteractor implements StudentServicePort {

    private final StudentPersistencePort repositoryPort;

    @Override
    public Student createStudent(Student student) {
        return repositoryPort.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return repositoryPort.findById(id)
                .map(savedStudent -> {
                    savedStudent.setFirstName(student.getFirstName());
                    savedStudent.setLastName(student.getLastName());
                    savedStudent.setAddress(student.getAddress());
                    savedStudent.setAge(student.getAge());
                    return repositoryPort.save(savedStudent);
                })
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public Student findStudentById(Long id) {
        return repositoryPort.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public List<Student> findAllStudents() {
        return repositoryPort.findAll();
    }

    @Override
    public void deleteStudentById(Long id) {
        if (repositoryPort.findById(id).isEmpty()) {
            throw new StudentNotFoundException();
        }
        repositoryPort.deleteById(id);
    }
}
