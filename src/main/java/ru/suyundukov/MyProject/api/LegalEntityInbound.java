package ru.suyundukov.MyProject.api;

import ru.suyundukov.MyProject.entity.LegalEntity;

import java.util.List;

public interface LegalEntityInbound {
    LegalEntity createLegalEntity(LegalEntity legalEntity);

    LegalEntity updateLegalEntity(Long id, LegalEntity legalEntity);

    LegalEntity getLegalEntityById(Long id);

    List<LegalEntity> getAllLegalEntity();

    void deleteLegalEntity(Long id);
}
