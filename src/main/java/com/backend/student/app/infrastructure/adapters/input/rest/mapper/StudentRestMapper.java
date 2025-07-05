package com.backend.student.app.infrastructure.adapters.input.rest.mapper;

import com.backend.student.app.domain.model.Student;
import com.backend.student.app.infrastructure.adapters.input.rest.dto.request.StudentCreateRequest;
import com.backend.student.app.infrastructure.adapters.input.rest.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentRestMapper {

    @Mapping(target = "id", ignore = true)
    Student toStudent(StudentCreateRequest request);

    StudentResponse toStudentResponse(Student student);

    List<StudentResponse> toStudentResponseList(List<Student> studentList);
}
