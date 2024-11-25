package ru.suyundukov.MyProject.api;

import ru.suyundukov.MyProject.entity.CommissionRate;

public interface CommissionRateInbound {
    /**
     * Поиск ставки комисии
     * @param afId
     * @return найденая ставка комисии
     */
    CommissionRate getByAfId(String afId);

    /**
     * Создание ставки комисии
     * @param commissionRate
     * @return создан ставка комисии
     */
    CommissionRate createCommissionRate(CommissionRate commissionRate);
}
