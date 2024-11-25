package ru.suyundukov.MyProject.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Тип контрагента
 */
@RequiredArgsConstructor
@Getter
public enum PartyType {
    UL("UL"),
    IP("IP"),
    FL("FL");
    private final String value;
}
