package com.backend.student.app.infrastructure.adapters.input.rest;

import com.backend.student.app.application.ports.input.StudentServicePort;
import com.backend.student.app.infrastructure.adapters.input.rest.dto.request.StudentCreateRequest;
import com.backend.student.app.infrastructure.adapters.input.rest.dto.response.StudentResponse;
import com.backend.student.app.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentServicePort servicePort;
    private final StudentRestMapper restMapper;

    @GetMapping("/v1/api")
    public List<StudentResponse> findAll() {
        return restMapper.toStudentResponseList(servicePort.findAllStudents());
    }

    @GetMapping("/v1/api/{id}")
    public StudentResponse findById(@PathVariable Long id) {
        return restMapper.toStudentResponse(servicePort.findStudentById(id));
    }

    @PostMapping("/v1/api")
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toStudentResponse(servicePort.createStudent(restMapper.toStudent(request))));
    }

    @PutMapping("/v1/api/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable Long id, @Valid @RequestBody StudentCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toStudentResponse(servicePort.updateStudent(id, restMapper.toStudent(request))));
    }

    @DeleteMapping("/v1/api/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        servicePort.deleteStudentById(id);
    }
}
