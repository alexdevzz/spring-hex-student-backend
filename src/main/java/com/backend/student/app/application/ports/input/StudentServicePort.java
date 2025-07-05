package com.backend.student.app.application.ports.input;

import com.backend.student.app.domain.model.Student;

import java.util.List;

public interface StudentServicePort {

    Student createStudent(Student student);

    Student updateStudent(Long id, Student student);

    Student findStudentById(Long id);

    List<Student> findAllStudents();

    void deleteStudentById(Long id);
}
