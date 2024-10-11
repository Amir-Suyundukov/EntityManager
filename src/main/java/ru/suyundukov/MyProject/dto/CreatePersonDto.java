package ru.suyundukov.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreatePersonDto {
    private String name;
    private String surName;
    private String patronymic;
    private String centralBank;//енумка
    private int snils;
}
