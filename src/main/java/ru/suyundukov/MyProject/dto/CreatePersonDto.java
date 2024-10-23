package ru.suyundukov.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.suyundukov.MyProject.entity.CounterPartyType;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreatePersonDto {
    private String name;
    private CounterPartyType type;
    private String surName;
    private String patronymic;
    private String centralBank;//енумка
    private int snils;
}
