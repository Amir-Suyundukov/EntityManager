package ru.suyundukov.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.suyundukov.MyProject.entity.*;

import java.math.BigDecimal;
import java.util.Currency;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommissionRateUpdateDto {
    private String afId;
    private CommissionType commissionType;
    private RateType rateType;
    private IndicatorType indicatorType;
    private Boolean isSurcharge;
    private Integer fundingPeriodFrom;
    private Integer fundingPeriodTo;
    private BigDecimal rateValue;
    private BigDecimal fixSumValue;
    private Currency currency;
    private FinancingStatus financingStatus;
    private String note;
    private String lmId;
    private CommissionRateStatus status;
    private Requirement requirement;
    private Agreement agreement;
    private Party party;
    private Contract contract;
    private Segment segment;
}
