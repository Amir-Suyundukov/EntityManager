package ru.suyundukov.MyProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.suyundukov.MyProject.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
