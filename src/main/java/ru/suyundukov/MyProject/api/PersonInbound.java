package ru.suyundukov.MyProject.api;

import ru.suyundukov.MyProject.entity.Person;

import java.util.List;

public interface PersonInbound {
    Person createPerson(Person person);

    Person updatePerson(Long id, Person person);

    Person getPersonById(Long id);

    List<Person> getAllPerson();

    void deletePerson(Long id);
}
