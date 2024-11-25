package ru.suyundukov.MyProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Слепок контрагента
 */
@Entity
@Table(name = "com_party")
@Getter
@Setter
@Accessors(chain = true)
public class Party extends DomainObject {
    /**
     * AF id контрагента
     */
    @Column(name = "af_id", nullable = false)
    private String afId;
    /**
     * Тип контрагента
     */
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PartyType type;
    /**
     * Пользовательское наименование
     */
    @Column(name = "user_name", nullable = false)
    private String userName;
    /**
     * Сокращенное наименование
     */
    @Column(name = "short_name")
    private String shortName;
    /**
     * ИНН/КИО
     */
    @Column(name = "inn")
    private String inn;
    /**
     * Основной ПИН EQ
     */
    @Column(name = "main_pin_eq")
    private String mainPinEq;
}
