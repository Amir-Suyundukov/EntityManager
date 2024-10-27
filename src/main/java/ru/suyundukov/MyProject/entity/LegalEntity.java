package ru.suyundukov.MyProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "legalentity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LegalEntity extends BusinessUnit {//ЮЛ
    @Column(name = "kpp")
    private int kpp;
    @Column(name = "type")
    private String type = "UL";
    @Column(name = "unique_id")
    private String uniqueId;
}
