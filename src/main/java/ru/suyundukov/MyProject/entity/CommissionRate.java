package ru.suyundukov.MyProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

@NamedEntityGraph(
        name = "filter Commission Rate by id",
        attributeNodes = {
//                @NamedAttributeNode(value = "agreements"),
                @NamedAttributeNode(value = "contract"),
                @NamedAttributeNode(value = "party"),
                @NamedAttributeNode(value = "requirement"),
                @NamedAttributeNode(value = "segment"),
                @NamedAttributeNode(value = "debtorsCreditors")
        }
)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "commission_rate")
public class CommissionRate extends BusinessEntity {//главный класс
    /**
     * AF id
     */
    @Column(name = "af_id", nullable = false)
    private String afId;
    /**
     * Тип комиссии
     */
    @Column(name = "commission_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CommissionType commissionType;
    /**
     * Тип ставки
     */
    @Column(name = "rate_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RateType rateType;
    /**
     * Тип индикатора
     */
    @Column(name = "indicator_type")
    @Enumerated(EnumType.STRING)
    private IndicatorType indicatorType;
    /**
     * Признак надбавки
     */
    @Column(name = "is_surcharge", nullable = false)
    private Boolean isSurcharge;
    /**
     * Дата начала действия ставки
     */
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    /**
     * Дата окончания действия ставки
     */
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    /**
     * Срок фондирования От (дней)
     */
    @Column(name = "funding_period_from")
    private Integer fundingPeriodFrom;
    /**
     * Срок фондирования До (дней)
     */
    @Column(name = "funding_period_to")
    private Integer fundingPeriodTo;
    /**
     * Значение ставки/надбавки
     */
    @Column(name = "rate_value")
    private BigDecimal rateValue;
    /**
     * Значение фиксированной суммы
     */
    @Column(name = "fix_sum_value")
    private BigDecimal fixSumValue;
    /**
     * Валюта
     */
    @Column(name = "currency", nullable = false)
    private Currency currency;
    /**
     * Статус финансирования
     */
    @Column(name = "financing_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private FinancingStatus financingStatus;
    /**
     * Примечание
     */
    @Column(name = "note")
    private String note;
    /**
     * LM ID
     */
    @Column(name = "lm_id")
    private String lmId;
    /**
     * Статус
     */
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private CommissionRateStatus status;
    /**
     * Данные поручения/требования
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "requirement_id")
    private Requirement requirement;
    /**
     * Данные договора
     */
    //сделать как у пати
    //get запрос на список
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "commission_rate_id")
    private List<Agreement> agreements;
    /**
     * Данные контрагента
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "party_id")
    private Party party;
    /**
     * Контракт
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contract_id")
    private Contract contract;
    /**
     * Кредиторы/дебиторы
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "commission_rate_id")
    private List<Party> debtorsCreditors;
    /**
     * Сегмент контрагента (Поставщика)
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "segment_id")
    private Segment segment;

    /**
     * Признак: обновляется / создается LM
     */
    @Transient
    private Boolean isLmUpdating;

    public CommissionRate setDebtorsCreditors(List<Party> debtorsCreditors) {
        if (this.debtorsCreditors == null) {
            this.debtorsCreditors = debtorsCreditors;
        } else if (debtorsCreditors == null) {
            this.debtorsCreditors.clear();
        } else {
            this.debtorsCreditors.clear();
            this.debtorsCreditors.addAll(debtorsCreditors);
        }
        return this;
    }

    public CommissionRate setAgreements(List<Agreement> agreements) {
        if (this.agreements == null) {
            this.agreements = agreements;
        } else if (agreements == null) {
            this.agreements.clear();
        } else {
            this.agreements.clear();
            this.agreements.addAll(agreements);
        }
        return this;
    }

    @JsonIgnore
    public boolean isActive() {
        LocalDate today = LocalDate.now();
        return !today.isBefore(startDate) && (endDate == null || !today.isAfter(endDate));
    }
}
