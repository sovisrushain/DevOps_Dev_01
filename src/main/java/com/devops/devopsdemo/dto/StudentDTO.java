package com.devops.devopsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    @NotNull(message = "NIC should not be empty")
    private String nic;
    @NotNull(message = "Name should not be empty")
    @Size(min = 3, max = 15 , message = "Name length should be between 3 to 15")
    private String name;
    @NotNull(message = "Year should not be empty")
    @Size(min = 3, max = 4)
    private int year;
    @NotNull(message = "Course should not be empty")
    private String course;
}
