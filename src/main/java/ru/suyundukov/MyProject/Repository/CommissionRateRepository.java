package ru.suyundukov.MyProject.Repository;

import ru.suyundukov.MyProject.entity.CommissionRate;

public interface CommissionRateRepository {
    /**
     * Получить запись ставки комисии
     * @param afId
     * @return ставка комисии
     */
    CommissionRate getByAfId(String afId);

    /**
     * Сохранение ставки комисии
     * @param commissionRate
     * @return ставка комисии
     */
    CommissionRate save(CommissionRate commissionRate);
}
