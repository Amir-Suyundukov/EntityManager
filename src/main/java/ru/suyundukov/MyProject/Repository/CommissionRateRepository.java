package ru.suyundukov.MyProject.Repository;

import ru.suyundukov.MyProject.entity.CommissionRate;
import ru.suyundukov.MyProject.entity.CommissionRateFilter;

import java.util.List;

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

    List<CommissionRate> findByFilter(CommissionRateFilter filter);
}
