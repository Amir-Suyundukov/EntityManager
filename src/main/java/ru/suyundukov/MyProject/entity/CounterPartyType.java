package ru.suyundukov.MyProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum CounterPartyType {
    IP("IP"),
    UL("UL"),
    FL("FL");

    private String value;

    CounterPartyType(String unique) {
        this.value = unique;
    }
}
