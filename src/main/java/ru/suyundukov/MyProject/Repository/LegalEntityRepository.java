package ru.suyundukov.MyProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.suyundukov.MyProject.entity.LegalEntity;

public interface LegalEntityRepository extends JpaRepository<LegalEntity, Long> {
}
