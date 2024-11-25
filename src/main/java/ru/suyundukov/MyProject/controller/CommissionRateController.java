package ru.suyundukov.MyProject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.suyundukov.MyProject.api.CommissionRateInbound;
import ru.suyundukov.MyProject.dto.CommissionRateCreateDto;
import ru.suyundukov.MyProject.dto.CommissionRateDto;
import ru.suyundukov.MyProject.entity.CommissionRate;
import ru.suyundukov.MyProject.mapper.CommissionRateMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tes")
@Tag(name = "Контроллер ставки комисии")
public class CommissionRateController {
    private final CommissionRateInbound commissionRateInbound;
    private final CommissionRateMapper commissionRateMapper;

    @GetMapping("/{afId}")
    @Operation(description = "Получение данных Ставки комисии по afId")
    public CommissionRateDto getCommissionRateByAfId(@PathVariable String afId) {
        CommissionRate commissionRate = commissionRateInbound.getByAfId(afId);
        return commissionRateMapper.mapToDto(commissionRate);
    }


    @PostMapping
    @Operation(description = "Создание Ставки Комисии")
    public CommissionRateDto createCommissionRate(@RequestBody CommissionRateCreateDto commissionRateCreateDto) {
        CommissionRate commissionRate = commissionRateMapper.mapToDomain(commissionRateCreateDto);
        CommissionRate savedCommissionRate = commissionRateInbound.createCommissionRate(commissionRate);
        return commissionRateMapper.mapToDto(savedCommissionRate);
    }
}