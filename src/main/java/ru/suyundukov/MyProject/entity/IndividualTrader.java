package ru.suyundukov.MyProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "individualtrader")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IndividualTrader extends BusinessUnit {
    @Column(name = "type")
    private String type = "IT";
    @Column(name = "unique_id")
    private String uniqueId;
}
