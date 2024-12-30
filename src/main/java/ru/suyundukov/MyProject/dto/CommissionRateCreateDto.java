package ru.suyundukov.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.suyundukov.MyProject.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommissionRateCreateDto {
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
    private RequirementDto requirement;
    private AgreementDto agreement;
    private PartyDto party;
    private ContractDto contract;
    private SegmentDto segment;
    private String createUserFullName;
    private String createUserLogin;
    private LocalDate startDate;
    private LocalDate endDate;//старт и энд создать (и сделать что старт раньше чем енд и все в юз кейс)
    private List<PartyDto> debtorsCreditors;
}
