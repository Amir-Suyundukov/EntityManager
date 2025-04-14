package ru.suyundukov.MyProject.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Тип индикатора
 * данный справочник продублирован в сервисах: agreements, monetary-claims, products
 */
@RequiredArgsConstructor
@Getter
public enum IndicatorType {
    KEYRATECB("Ключевая ставка ЦБ РФ"),
    PS("EURIBOR 1W"),
    PV("EURIBOR 1M"),
    PX("EURIBOR 3M"),
    OY("EURIBOR 6M"),
    OS("EURIBOR 1Y"),
    KI("SHIBOR ON"),
    KJ("SHIBOR 1W"),
    KK("SHIBOR 2W"),
    KL("SHIBOR 1M"),
    KM("SHIBOR 3M"),
    KN("SHIBOR 6M"),
    KO("SHIBOR 9M"),
    KP("SHIBOR 1Y"),
    L5("RUONIA"),
    IR("RUONIA Индекс"),
    JX("RUONIA 1M"),
    JY("RUONIA 3M"),
    JZ("RUONIA 6M"),
    IS("Ставка SOFR");

    private final String value;
}

