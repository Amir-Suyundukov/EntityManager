package ru.suyundukov.MyProject.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.suyundukov.MyProject.Repository.LegalEntityRepository;
import ru.suyundukov.MyProject.api.LegalEntityInbound;
import ru.suyundukov.MyProject.entity.LegalEntity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class LegalEntityService implements LegalEntityInbound {

    private final AtomicInteger integer = new AtomicInteger(0);

    private final LegalEntityRepository legalEntityRepository;

    public LegalEntity createLegalEntity(LegalEntity legalEntity) {
        String uniqueId = "UL-" + integer.incrementAndGet();
        legalEntity.setUniqueId(uniqueId);
        legalEntity.setType("UL");

        return legalEntityRepository.save(legalEntity);
    }

    public LegalEntity updateLegalEntity(Long id, LegalEntity legalEntity) {
        LegalEntity foundLegalEntity = legalEntityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("LegalEntity not found by ID - " + id));
        legalEntity.setFullName(legalEntity.getFullName());
        legalEntity.setShortName(legalEntity.getShortName());
        legalEntity.setKpp(legalEntity.getKpp());
        legalEntity.setPsrn(legalEntity.getPsrn());
        legalEntity.setInn(legalEntity.getInn());
        legalEntity.setOktmo(legalEntity.getOktmo());
        legalEntity.setCentralBank(legalEntity.getCentralBank());

        return legalEntityRepository.save(legalEntity);
    }

    public LegalEntity getLegalEntityById(Long id) {
        return legalEntityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("LegalEntity not found by ID - " + id));
    }

    public List<LegalEntity> getAllLegalEntity() {
        return legalEntityRepository.findAll();
    }

    public void deleteLegalEntity(Long id) {
        if (!legalEntityRepository.existsById(id)) {
            throw new EntityNotFoundException("LegalEntity not found by ID - " + id);
        }
        legalEntityRepository.deleteById(id);
    }
}
