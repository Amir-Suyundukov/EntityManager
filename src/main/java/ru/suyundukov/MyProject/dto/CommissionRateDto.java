package ru.suyundukov.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.suyundukov.MyProject.entity.*;
import ru.suyundukov.MyProject.entity.PartyType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommissionRateDto {
    private String afId;
    private EnumDictionaryDto<CommissionType> commissionType;
    private EnumDictionaryDto<AgreementType> agreementType;
    private EnumDictionaryDto<AnnualRateType> annualType;
    private EnumDictionaryDto<PartyType> partyType;
    private EnumDictionaryDto<RateType> rateType;
    private EnumDictionaryDto<IndicatorType> indicatorType;
    private Boolean isSurcharge;
    private Integer fundingPeriodFrom;
    private Integer fundingPeriodTo;
    private BigDecimal rateValue;
    private BigDecimal fixSumValue;
    private Currency currency;
    private EnumDictionaryDto<FinancingStatus> financingStatus;
    private String note;
    private String lmId;
    private EnumDictionaryDto<CommissionRateStatus> status;
    private RequirementDto requirement;
    private AgreementDto agreement;
    private PartyDto party;
    private ContractDto contract;
    private SegmentDto segment;
    private String createUserFullName;
    private String createUserLogin;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<AgreementDto> agreements;
    private List<PartyDto> debtorsCreditors;
}
