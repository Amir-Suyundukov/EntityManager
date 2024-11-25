package ru.suyundukov.MyProject.Repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.suyundukov.MyProject.entity.CommissionRate;

import java.util.Optional;

@Repository
public interface CommissionRateJpaRepository extends JpaRepository<CommissionRate, Long> {
    @EntityGraph(value = "infinite code")
    Optional<CommissionRate> findByAfId(String afId);
}
