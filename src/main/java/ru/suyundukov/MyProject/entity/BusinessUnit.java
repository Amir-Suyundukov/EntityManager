package ru.suyundukov.MyProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "businessunit")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessUnit extends CounterParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "shortname")
    private String shortName;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "psrn")
    private int psrn;
    @Column(name = "inn")
    private int inn;
    @Column(name = "oktmo")
    private String oktmo;
    @Column(name = "centralbank")
    private String centralBank;//енумка
}
