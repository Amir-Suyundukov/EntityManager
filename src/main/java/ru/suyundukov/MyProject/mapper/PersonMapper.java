package ru.suyundukov.MyProject.mapper;

import org.mapstruct.Mapper;
import ru.suyundukov.MyProject.dto.CreatePersonDto;
import ru.suyundukov.MyProject.dto.PersonDto;
import ru.suyundukov.MyProject.dto.UpdatePersonDto;
import ru.suyundukov.MyProject.entity.Person;

@Mapper(componentModel = "string")
public interface PersonMapper {
    PersonDto mapToDto(Person person);
    Person mapToDomain(CreatePersonDto createPersonDto);
    Person mapToDomain(UpdatePersonDto updatePersonDto);

}
