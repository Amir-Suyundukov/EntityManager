package ru.suyundukov.MyProject.Repository;

import ru.suyundukov.MyProject.entity.CommissionRate;
import ru.suyundukov.MyProject.entity.CommissionRateFilter;

import java.time.LocalDate;
import java.util.List;

public interface CommissionRateRepository {
    /**
     * Получить запись ставки комисии
     * @param afId
     * @return ставка комисии
     */
    CommissionRate getByAfId(String afId);
    CommissionRate getByLmId(String lmId);

    /**
     * Сохранение ставки комисии
     * @param commissionRate
     * @return ставка комисии
     */
    CommissionRate save(CommissionRate commissionRate);

    List<CommissionRate> findByFilter(CommissionRateFilter filter);

    List<CommissionRate> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}
