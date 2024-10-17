package ru.suyundukov.MyProject.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.suyundukov.MyProject.Repository.PersonRepository;
import ru.suyundukov.MyProject.api.PersonInbound;
import ru.suyundukov.MyProject.entity.Person;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService implements PersonInbound {

    private final PersonRepository personRepository;

    public Person createPerson(Person person) {
        String unique = person.getType();
        if(unique == null || unique.isEmpty()){
            throw new IllegalArgumentException("Type is required");
        }

        Integer maxId = personRepository.findMaxUniqueIdNumberByType(unique);
        int nextId = (maxId != null ? maxId : 0) + 1;

        person.setUniqueId(unique + "-" + nextId);

        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person person) {
        Person foundPerson = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found by id: " + id));
        foundPerson.setName(person.getName());
        foundPerson.setSurName(person.getSurName());
        foundPerson.setPatronymic(person.getPatronymic());
        foundPerson.setSnils(person.getSnils());
        foundPerson.setCentralBank(person.getCentralBank());
        return personRepository.save(foundPerson);
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found by id: " + id));
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public void deletePerson(Long id) {
        if (!personRepository.existsById(id)) {
            throw new EntityNotFoundException("Person not found by id: " + id);
        }
        personRepository.deleteById(id);
    }

}
