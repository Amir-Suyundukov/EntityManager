package ru.suyundukov.MyProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum UniqueId {
    IP("IP"),
    UL("UL"),
    FL("FL");

    private String unique;

    UniqueId(String unique) {
        this.unique = unique;
    }
}
