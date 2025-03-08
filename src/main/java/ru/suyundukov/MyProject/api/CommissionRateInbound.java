package ru.suyundukov.MyProject.api;

import ru.suyundukov.MyProject.entity.CommissionRate;
import ru.suyundukov.MyProject.entity.CommissionRateFilter;

import java.time.LocalDate;
import java.util.List;

public interface CommissionRateInbound {
    /**
     * Поиск ставки комисии
     * @param afId
     * @return найденая ставка комисии
     */
    CommissionRate getByAfId(String afId);

    CommissionRate getByLmId(String lmId);

    /**
     * Создание ставки комисии
     * @param commissionRate
     * @return создан ставка комисии
     */
    CommissionRate createCommissionRate(CommissionRate commissionRate);

    List<CommissionRate> findByFilter(CommissionRateFilter filter);

    List<CommissionRate> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}
