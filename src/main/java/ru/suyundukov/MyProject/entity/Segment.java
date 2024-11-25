package ru.suyundukov.MyProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Слепок Сегмента
 */
@Entity
@Table(name = "com_segment")
@Accessors(chain = true)
@Getter
@Setter
public class Segment extends DomainObject {
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "value", nullable = false)
    private String value;
}

