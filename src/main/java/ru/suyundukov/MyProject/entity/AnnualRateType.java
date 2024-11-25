package ru.suyundukov.MyProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Тип годовой ставки
 */
@AllArgsConstructor
@Getter
public enum AnnualRateType {
    FIXED("Фиксированная"),
    FLOATING("Плавающая");

    private final String value;

    public static AnnualRateType getByCode(String code) {
        for (AnnualRateType e : values()) {
            if (e.name().equals(code)) {
                return e;
            }
        }
        return null;
    }
}
