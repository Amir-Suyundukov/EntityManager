package ru.suyundukov.MyProject.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BusinessUnit extends CounterParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortName;
    private String fullName;
    private int psrn;
    private int inn;
    private String oktmo;
    private String centralBank;//енумка
}
