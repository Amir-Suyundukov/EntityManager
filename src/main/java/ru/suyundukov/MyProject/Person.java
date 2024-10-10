package ru.suyundukov.MyProject;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Person extends CounterParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;
    private String patronymic;
    private String centralBank;//енумка
    private int snils;
    private LocalDate dateOfBirth;
}
