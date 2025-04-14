package ru.suyundukov.MyProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * Тип комиссии
 */


@Getter
@RequiredArgsConstructor
public enum CommissionType {
    AUDZ("Комиссия за АУДЗ", true),
    DOCUMENT_PROCESSING("Комиссия за обработку документов", true),
    COM_CREDIT("Комиссия за ком. кредит", false),
    DEBTOR_SURETY("Комиссия за поручительство за Дебитора", false),
    FUNDING("Комиссия за финансирование", true),
    FUDZ("Комиссия за ФУДЗ", true),
    AD_REWARD("Вознаграждение по АД", true),
    PAYMENT_DEFERRAL("Вознаграждение за отсрочку платежа", true),
    AD_REWARD_WITHOUT_PDP("Вознаграждение по АД без ПДП", true);

    private final String value;
    private final Boolean isVatSubject;

    public static Set<CommissionType> getAgencyCommissionTypes() {
        return Set.of(AD_REWARD, AD_REWARD_WITHOUT_PDP);
    }
}

