package ru.suyundukov.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateLegalEntityDto {
    private String shortName;
    private String fullName;
    private int psrn;
    private int inn;
    private String oktmo;
    private String centralBank;
}
