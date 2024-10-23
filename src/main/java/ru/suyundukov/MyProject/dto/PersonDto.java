package ru.suyundukov.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.suyundukov.MyProject.entity.CounterPartyType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDto {
    private Long id;
    private String uniqueId;
    private CounterPartyType type;
    private String name;
    private String surName;
    private String patronymic;
    private String centralBank;//енумка
    private int snils;
}
