package ru.suyundukov.MyProject.Repository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.suyundukov.MyProject.entity.CommissionRate;

@Component
@RequiredArgsConstructor
public class CommissionRateRepositoryImpl implements CommissionRateRepository {

    private final CommissionRateJpaRepository commissionRateJpaRepository;

    @Override
    public CommissionRate getByAfId(String afId) {
        return commissionRateJpaRepository.findByAfId(afId)
                .orElseThrow(() -> new EntityNotFoundException("CommissionRate with afId " + afId + " not found"));
    }

    @Override
    public CommissionRate save(CommissionRate commissionRate){
        return commissionRateJpaRepository.save(commissionRate);
    }

}
