package com.backend.student.app.infrastructure.adapters.input.rest.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
}
