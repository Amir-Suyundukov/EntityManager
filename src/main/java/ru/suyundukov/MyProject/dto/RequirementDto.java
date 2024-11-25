package ru.suyundukov.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequirementDto {
    private String afId;
    private String number;
    private LocalDate date;
    private String registryAfId;
    private String registryNumber;
    private LocalDate registryDate;
}
