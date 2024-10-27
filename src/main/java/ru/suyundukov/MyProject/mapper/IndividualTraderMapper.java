package ru.suyundukov.MyProject.mapper;

import org.mapstruct.Mapper;
import ru.suyundukov.MyProject.dto.CreateIndividualTraderDto;
import ru.suyundukov.MyProject.dto.IndividualTraderDto;
import ru.suyundukov.MyProject.dto.UpdateIndividualTraderDto;
import ru.suyundukov.MyProject.entity.IndividualTrader;

@Mapper(componentModel = "spring")
public interface IndividualTraderMapper {
    IndividualTraderDto mapToDto(IndividualTrader individualTrader);

    IndividualTrader mapToDomain(CreateIndividualTraderDto createIndividualTraderDto);

    IndividualTrader mapToDomain(UpdateIndividualTraderDto updateIndividualTraderDto);

}
