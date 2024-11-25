package ru.suyundukov.MyProject.entity;

import lombok.*;

/**
 * Статус ставки комиссии
 */
@Getter
@RequiredArgsConstructor
public enum CommissionRateStatus {
    /**
     * Используется
     */
    OPEN("открыто"),
    /**
     * Удалена
     */
    DELETED("удалено");

    private final String value;
}

