package ru.suyundukov.MyProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * Слепок Договора
 */
@Entity
@Table(name = "com_agreement")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Agreement extends DomainObject {
    /**
     * AF id договора
     */
    @Column(name = "af_id", nullable = false)
    private String afId;
    /**
     * Тип договора
     */
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AgreementType type;
    /**
     * Номер договора
     */
    @Column(name = "number", nullable = false)
    private String number;
    /**
     * Дата договора
     */
    @Column(name = "date")
    private LocalDate date;
}
