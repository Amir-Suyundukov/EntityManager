package ru.suyundukov.MyProject.Repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.suyundukov.MyProject.entity.CommissionRate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommissionRateJpaRepository extends JpaRepository<CommissionRate, Long> {
    @EntityGraph(value = "filter Commission Rate by id")
    Optional<CommissionRate> findByAfId(String afId);

    Optional<CommissionRate> findByLmId(String lmId);

    @Query("""
    select cr
    from CommissionRate cr
    where cr.startDate <= :endDate and cr.endDate >= :startDate""")
    List<CommissionRate> findInInterval(@Param("startDate") LocalDate startDate,
                                        @Param("endDate") LocalDate endDate);

}
