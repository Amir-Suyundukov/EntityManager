package ru.suyundukov.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LegalEntityDto {
    private Long id;
    private String type;
    private String uniqueId;
    private String shortName;
    private String fullName;
    private int psrn;
    private int inn;
    private String oktmo;
    private String centralBank;
}
