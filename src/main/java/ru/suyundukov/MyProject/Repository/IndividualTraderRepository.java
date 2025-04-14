package ru.suyundukov.MyProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.suyundukov.MyProject.entity.IndividualTrader;

@Repository
public interface IndividualTraderRepository extends JpaRepository<IndividualTrader , Long> {
}
