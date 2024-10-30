package ru.suyundukov.MyProject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.suyundukov.MyProject.api.PersonInbound;
import ru.suyundukov.MyProject.dto.CreatePersonDto;
import ru.suyundukov.MyProject.dto.PersonDto;
import ru.suyundukov.MyProject.dto.UpdatePersonDto;
import ru.suyundukov.MyProject.entity.Person;
import ru.suyundukov.MyProject.mapper.PersonMapper;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
@Tag(name = "Контроллер физического лица(IP)")
public class PersonController {

    private final PersonInbound personInbound;

    private final PersonMapper personMapper;

    @PostMapping
    @Operation(description = "Создание физ лица")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto createPerson(@RequestBody CreatePersonDto createPersonDto) {
        Person person = personMapper.mapToDomain(createPersonDto);
        Person savedPerson = personInbound.createPerson(person);
        return personMapper.mapToDto(savedPerson);
    }

    @PutMapping("/{id}")
    @Operation(description = "Обновление физ лица")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto updatePerson(@PathVariable Long id, @RequestBody UpdatePersonDto updatePersonDto) {
        Person person = personMapper.mapToDomain(updatePersonDto);
        Person savedPerson = personInbound.updatePerson(id, person);
        return personMapper.mapToDto(savedPerson);
    }

    @GetMapping("/{id}")
    @Operation(description = "Поиск физ лица по id")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto getPersonById(@PathVariable Long id) {
        Person person = personInbound.getPersonById(id);
        return personMapper.mapToDto(person);
    }

    @GetMapping
    @Operation(description = "Список физ лиц")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> getAllPerson() {
        List<Person> personList = personInbound.getAllPerson();
        return personList.stream().map(personMapper::mapToDto).toList();
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Удаление физ лица по id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personInbound.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}
