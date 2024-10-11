package ru.suyundukov.MyProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.suyundukov.MyProject.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
