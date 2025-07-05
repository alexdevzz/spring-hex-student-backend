package com.backend.student.app.infrastructure.adapters.output.database.postgres.mapper;

import com.backend.student.app.domain.model.Student;
import com.backend.student.app.infrastructure.adapters.output.database.postgres.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    StudentEntity ToStudentEntity(Student student);

    Student ToStudent(StudentEntity studentEntity);

    List<Student> ToStudentList(List<StudentEntity> studentEntityList);

    List<StudentEntity> ToStudentEntityList(List<Student> studentList);
}
