package com.backend.student.app.infrastructure.adapters.output.database.postgres;

import com.backend.student.app.application.ports.output.StudentPersistencePort;
import com.backend.student.app.domain.model.Student;
import com.backend.student.app.infrastructure.adapters.output.database.postgres.mapper.StudentPersistenceMapper;
import com.backend.student.app.infrastructure.adapters.output.database.postgres.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentJpaRepository studentJpaRepository;
    private final StudentPersistenceMapper studentPersistenceMapper;

    @Override
    public Optional<Student> findById(Long id) {
        return studentJpaRepository.findById(id)
                .map(studentPersistenceMapper::ToStudent);
    }

    @Override
    public List<Student> findAll() {
        return studentPersistenceMapper.ToStudentList(studentJpaRepository.findAll());
    }

    @Override
    public Student save(Student student) {
        return studentPersistenceMapper.ToStudent(studentJpaRepository.save(studentPersistenceMapper.ToStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
        studentJpaRepository.deleteById(id);
    }
}
