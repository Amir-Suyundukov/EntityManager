package ru.suyundukov.MyProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "individualtrader")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IndividualTrader extends BusinessUnit {
    @Column(name = "type")
    private String type = "IT";//индивидуал
    @Column(name = "unique_id")
    private String uniqueId;
}
