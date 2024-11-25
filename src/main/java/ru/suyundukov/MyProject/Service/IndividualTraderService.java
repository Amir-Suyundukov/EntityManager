package ru.suyundukov.MyProject.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.suyundukov.MyProject.Repository.IndividualTraderRepository;
import ru.suyundukov.MyProject.api.IndividualTraderInbound;
import ru.suyundukov.MyProject.entity.IndividualTrader;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class IndividualTraderService implements IndividualTraderInbound {
    // изменить на запрос в бд , подсмотреть в agreements AbstractAfIdGenerator, FactoringAgreementAfIdGenerator, FactoringAgreement,
    // @GeneratorType(type = FactoringAgreementAfIdGenerator.class, when = GenerationTime.INSERT)
    private final AtomicInteger integer = new AtomicInteger(0);

    private final IndividualTraderRepository individualTraderRepository;

    public IndividualTrader createIndividualTrader(IndividualTrader individualTrader) {
        String uniqueId = "IT-" + integer.incrementAndGet();
        individualTrader.setUniqueId(uniqueId);
        individualTrader.setType("IT");

        return individualTraderRepository.save(individualTrader);
    }

    public IndividualTrader updateIndividualTrader(Long id, IndividualTrader individualTrader) {
        IndividualTrader foundById = individualTraderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("IndividualTrader not found by ID - " + id));

        //сделать правильно
        foundById.setFullName(individualTrader.getFullName());
        foundById.setShortName(individualTrader.getShortName());
        foundById.setPsrn(individualTrader.getPsrn());
        foundById.setInn(individualTrader.getInn());
        foundById.setOktmo(individualTrader.getOktmo());
        foundById.setCentralBank(individualTrader.getCentralBank());

        return individualTraderRepository.save(individualTrader);
    }

    public IndividualTrader getIndividualTraderByID(Long id) {
        return individualTraderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("IndividualTrader not found by ID - " + id));
    }

    public List<IndividualTrader> foundAll() {
        return individualTraderRepository.findAll();
    }

    public void deleteIndividualTrader(Long id) {
        if (!individualTraderRepository.existsById(id)) {
            throw new EntityNotFoundException("IndividualTrader not found by ID - " + id);
        }
        individualTraderRepository.deleteById(id);
    }
}
