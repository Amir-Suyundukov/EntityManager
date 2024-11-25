package ru.suyundukov.MyProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Тип ставки
 */
@AllArgsConstructor
@Getter
public enum RateType {
    //CHECKSTYLE:OFF
    FIXED_ANNUAL("% годовых", AnnualRateType.FIXED, "% годовых фикс."),
    FLOATING_ANNUAL("% годовых", AnnualRateType.FLOATING, "% годовых плав."),
    FIXED_DAILY("% в день", AnnualRateType.FIXED, "% в день фикс."),
    FIXED_AMOUNT("фиксированная сумма", null, "фиксированная сумма");

    //CHECKSTYLE:ON
    private final String value;
    private final AnnualRateType annualRateType;
    private final String userName;
}

