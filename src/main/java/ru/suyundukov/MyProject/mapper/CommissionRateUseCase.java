package ru.suyundukov.MyProject.mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.suyundukov.MyProject.Repository.CommissionRateRepository;
import ru.suyundukov.MyProject.api.CommissionRateInbound;
import ru.suyundukov.MyProject.entity.CommissionRate;
import ru.suyundukov.MyProject.entity.CommissionRateFilter;

import java.time.Instant;
import java.util.List;

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
        validateDeadline(commissionRate);
        commissionRate.getCreationInfo().setCreateDateTime(Instant.now());
        return commissionRateRepository.save(commissionRate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommissionRate> findByFilter(CommissionRateFilter filter) {
        log.info("ФИЛЬТРУЕМ");
        return commissionRateRepository.findByFilter(filter);
    }

    public static void validateDeadline(CommissionRate commissionRate) {
        if (commissionRate.getStartDate() != null && commissionRate.getEndDate() != null
                && !commissionRate.getEndDate().isAfter(commissionRate.getStartDate())) {
            log.error("Ошибка валидации дат: startDate = {}, endDate = {}",
                    commissionRate.getStartDate(), commissionRate.getEndDate());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "НЕПРАВИЛЬНО УКАЗАНЫ ДАТЫ: СТАРТ ДОЛЖЕН БЫТЬ РАНЬШЕ ЕНДА"
            );
        }
    }

}
