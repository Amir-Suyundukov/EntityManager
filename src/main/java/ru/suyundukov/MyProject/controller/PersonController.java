package ru.suyundukov.MyProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
//tag
public class PersonController {

    private final PersonInbound personInbound;

    private final PersonMapper personMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto createPerson(@RequestBody CreatePersonDto createPersonDto) {
        Person person = personMapper.mapToDomain(createPersonDto);
        Person savedPerson = personInbound.createPerson(person);
        return personMapper.mapToDto(savedPerson);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto updatePerson(@PathVariable Long id, @RequestBody UpdatePersonDto updatePersonDto) {
        Person person = personMapper.mapToDomain(updatePersonDto);
        Person savedPerson = personInbound.updatePerson(id, person);
        return personMapper.mapToDto(savedPerson);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto getPersonById(@PathVariable Long id) {
        Person person = personInbound.getPersonById(id);
        return personMapper.mapToDto(person);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> getAllPerson() {
        List<Person> personList = personInbound.getAllPerson();
        return personList.stream().map(personMapper::mapToDto).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personInbound.deletePerson(id);
        return ResponseEntity.ok().build();
    }


}
