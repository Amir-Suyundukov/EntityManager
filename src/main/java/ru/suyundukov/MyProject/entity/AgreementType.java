package ru.suyundukov.MyProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Тип договора
 */
@RequiredArgsConstructor
@Getter
public enum AgreementType {
    AGENCY("AGENCY"),
    GENERAL("GENERAL");
    private final String value;
}
