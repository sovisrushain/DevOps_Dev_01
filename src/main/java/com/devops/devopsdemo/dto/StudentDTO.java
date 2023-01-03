package com.devops.devopsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    @NotNull(message = "NIC should not be empty")
    private String nic;
    @NotNull(message = "Name should not be empty")
    private String name;
    @NotNull(message = "Year should not be empty")
    private int year;
    @NotNull(message = "Course should not be empty")
    private String course;
}
