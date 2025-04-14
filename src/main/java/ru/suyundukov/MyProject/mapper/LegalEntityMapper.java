package ru.suyundukov.MyProject.mapper;

import org.mapstruct.Mapper;
import ru.suyundukov.MyProject.dto.CreateLegalEntityDto;
import ru.suyundukov.MyProject.dto.LegalEntityDto;
import ru.suyundukov.MyProject.dto.UpdateLegalEntityDto;
import ru.suyundukov.MyProject.entity.LegalEntity;

@Mapper(componentModel = "spring")
public interface LegalEntityMapper {
    LegalEntityDto mapToDto(LegalEntity legalEntity);

    LegalEntity mapToDomain(CreateLegalEntityDto createLegalEntityDto);

    LegalEntity mapToDomain(UpdateLegalEntityDto updateLegalEntity);
}
