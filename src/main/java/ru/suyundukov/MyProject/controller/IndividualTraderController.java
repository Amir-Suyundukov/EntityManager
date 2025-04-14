package ru.suyundukov.MyProject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.suyundukov.MyProject.api.IndividualTraderInbound;
import ru.suyundukov.MyProject.dto.CreateIndividualTraderDto;
import ru.suyundukov.MyProject.dto.IndividualTraderDto;
import ru.suyundukov.MyProject.dto.UpdateIndividualTraderDto;
import ru.suyundukov.MyProject.entity.IndividualTrader;
import ru.suyundukov.MyProject.mapper.IndividualTraderMapper;

import java.util.List;

@RestController
@RequestMapping("/trader")
@RequiredArgsConstructor
@Tag(name = "Контроллер индивидуального предпринимателя(IT)")
public class IndividualTraderController {

    private final IndividualTraderInbound individualTraderInbound;

    private final IndividualTraderMapper individualTraderMapper;

    @PostMapping
    @Operation(description = "Создание ИП")
    @ResponseStatus(HttpStatus.CREATED)
    public IndividualTraderDto createdIndividualTrader(@RequestBody CreateIndividualTraderDto createIndividualTraderDto) {
        IndividualTrader create = individualTraderMapper.mapToDomain(createIndividualTraderDto);
        IndividualTrader saved = individualTraderInbound.createIndividualTrader(create);
        return individualTraderMapper.mapToDto(saved);
    }

    @PutMapping
    @Operation(description = "Обновление ИП")
    @ResponseStatus(HttpStatus.OK)
    public IndividualTraderDto updateIndividualTrader(@PathVariable Long id, @RequestBody UpdateIndividualTraderDto updateIndividualTraderDto) {
        IndividualTrader create = individualTraderMapper.mapToDomain(updateIndividualTraderDto);
        IndividualTrader saved = individualTraderInbound.updateIndividualTrader(id, create);
        return individualTraderMapper.mapToDto(saved);
    }

    @GetMapping("/{id}")
    @Operation(description = "Поиск Ип по id")
    @ResponseStatus(HttpStatus.OK)
    public IndividualTraderDto getIndividualTraderById(@PathVariable Long id) {
        IndividualTrader individualTrader = individualTraderInbound.getIndividualTraderByID(id);
        return individualTraderMapper.mapToDto(individualTrader);
    }

    @GetMapping
    @Operation(description = "Список ИП")
    @ResponseStatus(HttpStatus.OK)
    public List<IndividualTraderDto> getAllIndividualTrader() {
        List<IndividualTrader> individualTraders = individualTraderInbound.foundAll();
        return individualTraders.stream().map(individualTraderMapper::mapToDto).toList();
    }

    @DeleteMapping
    @Operation(description = "Удаление ИП по id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteIndividualTrader(@PathVariable Long id) {
        individualTraderInbound.deleteIndividualTrader(id);
        return ResponseEntity.ok().build();
    }
}
