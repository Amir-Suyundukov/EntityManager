package ru.suyundukov.MyProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * Слепок по поручению
 */
@Entity
@Table(name = "requirement")
@Getter
@Setter
@Accessors(chain = true)
public class Requirement extends DomainObject {
    /**
     * AF id требования
     */
    @Column(name = "af_id")
    private String afId;
    /**
     * Номер требования
     */
    @Column(name = "number")
    private String number;
    /**
     * Дата требования
     */
    @Column(name = "date")
    private LocalDate date;
    /**
     * AF id реестра требований
     */
    @Column(name = "registry_af_id")
    private String registryAfId;
    /**
     * Номер реестра требований
     */
    @Column(name = "registry_number")
    private String registryNumber;
    /**
     * Дата реестра
     */
    @Column(name = "registry_date")
    private LocalDate registryDate;
}

