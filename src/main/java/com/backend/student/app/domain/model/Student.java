package com.backend.student.app.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;

}
