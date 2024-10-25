package ru.suyundukov.MyProject.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.suyundukov.MyProject.Repository.PersonRepository;
import ru.suyundukov.MyProject.api.PersonInbound;
import ru.suyundukov.MyProject.entity.Person;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class PersonService implements PersonInbound {

    private final AtomicInteger integer = new AtomicInteger(0);

    private final PersonRepository personRepository;

    public Person createPerson(Person person) {
        String uniqueId = "IP-" + integer.incrementAndGet();
        person.setUniqueId(uniqueId);
        person.setType("IP");

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
