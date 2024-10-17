package ru.suyundukov.MyProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
@Getter
@Setter
@Entity
public class Person extends CounterParty {
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(unique = true)
    private String uniqueId;
    @Column(name = "surname")
    private String surName;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "centralbank")
    private String centralBank;//енумка
    @Column(name = "snils")
    private int snils;
    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;
}
