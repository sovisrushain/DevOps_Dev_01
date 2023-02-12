package com.devops.devopsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    @NotNull(message = "NIC should not be empty")
    @Pattern(regexp = "^([0-9]{9}[x|X|v|V]|[0-9]{12})$", message = "Invalid ID format")
    private String nic;
    @NotNull(message = "Name should not be empty")
    private String name;
    @NotNull(message = "Year should not be empty")
    @Pattern(regexp = "^(19|20)\\d{2}$", message = "Invalid year format")
    private String year;
    @NotNull(message = "Course should not be empty")
    @NotBlank(message = "Course should not be empty")
    private String course;
}

