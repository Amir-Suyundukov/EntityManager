package ru.suyundukov.MyProject.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import ru.suyundukov.MyProject.entity.CommissionRate;
import ru.suyundukov.MyProject.entity.CommissionRateFilter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommissionRateRepositoryImpl implements CommissionRateRepository {

    private final CommissionRateJpaRepository commissionRateJpaRepository;
    @PersistenceContext
    private EntityManager entityManager;

    //pri f агриментджарепос (создать и метод найти по комишон рат ид)
    @Override
    public CommissionRate getByAfId(String afId) {
        CommissionRate commissionRate = commissionRateJpaRepository.findByAfId(afId)
                .orElseThrow(() -> new EntityNotFoundException("CommissionRate with afId " + afId + " not found"));
        Hibernate.initialize(commissionRate.getAgreements());
        //тут нужно написать чтобы нашлись все договара (агримент джипа репос

        return commissionRate;
    }
    @Override
    public CommissionRate getByLmId(String lmId) {
        CommissionRate commissionRate = commissionRateJpaRepository.findByLmId(lmId)
                .orElseThrow(() -> new EntityNotFoundException("CommissionRate with lmId " + lmId + " not found"));
        Hibernate.initialize(commissionRate.getAgreements());

        return commissionRate;
    }


    @Override
    public CommissionRate save(CommissionRate commissionRate) {
        return commissionRateJpaRepository.save(commissionRate);
    }

    @Override
    public List<CommissionRate> findByFilter(CommissionRateFilter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CommissionRate> criteriaQuery = criteriaBuilder.createQuery(CommissionRate.class);
        Root<CommissionRate> commissionRateRoot = criteriaQuery.from(CommissionRate.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getAfId() != null && !filter.getAfId().isEmpty()) {
            predicates.add(criteriaBuilder.equal(commissionRateRoot.get("afId"), filter.getAfId()));
        }
        if (filter.getLmId() != null && !filter.getLmId().isEmpty()) {
            predicates.add(criteriaBuilder.equal(commissionRateRoot.get("lmId"), filter.getLmId()));
        }

        criteriaQuery.select(commissionRateRoot).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<CommissionRate> findByStartDateBetween(LocalDate startDate, LocalDate endDate) {
        return commissionRateJpaRepository.findInInterval(startDate, endDate);
    }
}
