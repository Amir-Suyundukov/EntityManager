package ru.suyundukov.MyProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.suyundukov.MyProject.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT COALESCE(MAX(CAST(SUBSTRING(p.uniqueId, LENGTH(:unique) + 2) AS int)), 0) FROM Person p WHERE p.type = :unique")
    Integer findMaxUniqueIdNumberByType(String unique);
}
