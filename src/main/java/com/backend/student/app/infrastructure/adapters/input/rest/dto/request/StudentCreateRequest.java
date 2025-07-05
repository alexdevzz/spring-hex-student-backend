package com.backend.student.app.infrastructure.adapters.input.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

    @NotBlank(message = "Field firt_name cannot be empty or null")
    private String firstName;

    @NotBlank(message = "Field last_name cannot be empty or null")
    private String lastName;

    @NotBlank(message = "Field address cannot be empty or null")
    private String address;

    @NotNull(message = "Flied age cannot be null")
    private Integer Age;

}
