package ru.suyundukov.MyProject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.suyundukov.MyProject.dto.*;
import ru.suyundukov.MyProject.entity.*;
import ru.suyundukov.MyProject.entity.PartyType;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommissionRateMapper {
    @Mapping(target = "createUserFullName", source = "creationInfo.createUserFullName")
    @Mapping(target = "createUserLogin", source = "creationInfo.createUserLogin")
    CommissionRateDto mapToDto(CommissionRate commissionRate);

    @Mapping(target = "creationInfo.createUserFullName", source = "createUserFullName")
    @Mapping(target = "creationInfo.createUserLogin", source = "createUserLogin")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    CommissionRate mapToDomain(CommissionRateCreateDto commissionRateCreateDto);

    List<CommissionRateDto> mapToDto(List<CommissionRate> commissionRates);

    CommissionRateFilter mapFromDto(CommissionRateFilterDto commissionRateFilterDto);

    RequirementDto requirementToRequirementDto(Requirement requirement);
    Requirement requirementDtoToRequirement(RequirementDto requirementDto);

    AgreementDto agreementToAgreementDto(Agreement agreement);
    Agreement agreementDtoToAgreement(AgreementDto agreementDto);

    PartyDto partyToPartyDto(Party party);
    Party partyDtoToParty(PartyDto partyDto);

    ContractDto contractToContractDto(Contract contract);
    Contract contractDtoToContract(ContractDto contractDto);

    SegmentDto segmentToSegmentDto(Segment segment);
    Segment segmentDtoToSegment(SegmentDto segmentDto);

    List<AgreementDto> agreementsToAgreementDtos(List<Agreement> agreements);
    List<Agreement> agreementDtosToAgreements(List<AgreementDto> agreementDtos);

    @Mapping(target = "code", source = ".")
    EnumDictionaryDto<CommissionRateStatus> mapToDto(CommissionRateStatus commissionRateStatus);

    @Mapping(target = "code", source = ".")
    EnumDictionaryDto<IndicatorType> mapToDto(IndicatorType indicatorType);

    @Mapping(target = "code", source = ".")
    EnumDictionaryDto<AgreementType> mapToDto(AgreementType agreementType);

    @Mapping(target = "code", source = ".")
    EnumDictionaryDto<AnnualRateType> mapToDto(AnnualRateType annualRateType);

    @Mapping(target = "code", source = ".")
    EnumDictionaryDto<FinancingStatus> mapToDto(FinancingStatus financingStatus);

    @Mapping(target = "code", source = ".")
    EnumDictionaryDto<PartyType> mapToDto(PartyType partyType);

    @Mapping(target = "code", source = ".")
    EnumDictionaryDto<RateType> mapToDto(RateType rateType);

    @Mapping(target = "code", source = ".")
    EnumDictionaryDto<CommissionType> mapToDto(CommissionType commissionType);
}
