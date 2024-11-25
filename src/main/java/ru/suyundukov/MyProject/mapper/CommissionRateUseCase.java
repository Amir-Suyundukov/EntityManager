package ru.suyundukov.MyProject.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.suyundukov.MyProject.Repository.CommissionRateRepository;
import ru.suyundukov.MyProject.api.CommissionRateInbound;
import ru.suyundukov.MyProject.entity.CommissionRate;

import lombok.extern.slf4j.Slf4j;
import java.time.Instant;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommissionRateUseCase implements CommissionRateInbound {
    private final CommissionRateRepository commissionRateRepository;

    @Override
    @Transactional
    public CommissionRate getByAfId(String afId) {
        log.info("Getting commission rate by AfId: {}", afId);
        return commissionRateRepository.getByAfId(afId);
    }

    @Override
    @Transactional
    public CommissionRate createCommissionRate(CommissionRate commissionRate) {
        log.info("Creating commission rate");
        commissionRate.getCreationInfo().setCreateDateTime(Instant.now());
        return commissionRateRepository.save(commissionRate);
    }
}
