package ru.suyundukov.MyProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Слепок Контракта
 */
@Entity
@Table(name = "com_contract")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contract extends DomainObject {
    /**
     * AF ID контракта
     */
    @Column(name = "af_id", nullable = false)
    private String afId;
    /**
     * Номер контракта
     */
    @Column(name = "number", nullable = false)
    private String number;
}
