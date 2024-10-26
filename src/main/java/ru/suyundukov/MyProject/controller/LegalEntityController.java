package ru.suyundukov.MyProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.suyundukov.MyProject.api.LegalEntityInbound;
import ru.suyundukov.MyProject.dto.CreateLegalEntityDto;
import ru.suyundukov.MyProject.dto.LegalEntityDto;
import ru.suyundukov.MyProject.dto.UpdateLegalEntityDto;
import ru.suyundukov.MyProject.entity.LegalEntity;
import ru.suyundukov.MyProject.mapper.LegalEntityMapper;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LegalEntityController {

    private final LegalEntityInbound legalEntityInbound;

    private final LegalEntityMapper legalEntityMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LegalEntityDto createLegalEntity(@RequestBody CreateLegalEntityDto createLegalEntityDto) {
        LegalEntity legalEntity = legalEntityMapper.mapToDomain(createLegalEntityDto);
        LegalEntity savedLegalEntity = legalEntityInbound.createLegalEntity(legalEntity);
        return legalEntityMapper.mapToDto(savedLegalEntity);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public LegalEntityDto updateLegalEntity(@PathVariable Long id, @RequestBody UpdateLegalEntityDto updateLegalEntityDto) {
        LegalEntity legalEntity = legalEntityMapper.mapToDomain(updateLegalEntityDto);
        LegalEntity savedLegalEntity = legalEntityInbound.updateLegalEntity(id, legalEntity);
        return legalEntityMapper.mapToDto(savedLegalEntity);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LegalEntityDto getLegalEntityById(@PathVariable Long id) {
        LegalEntity legalEntity = legalEntityInbound.getLegalEntityById(id);
        return legalEntityMapper.mapToDto(legalEntity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LegalEntityDto> getAllLegalEntity() {
        List<LegalEntity> legalEntities = legalEntityInbound.getAllLegalEntity();
        return legalEntities.stream().map(legalEntityMapper::mapToDto).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteLegalEntity(@PathVariable Long id) {
        legalEntityInbound.deleteLegalEntity(id);
        return ResponseEntity.ok().build();
    }
}
