package ru.suyundukov.MyProject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.suyundukov.MyProject.api.CommissionRateInbound;
import ru.suyundukov.MyProject.dto.CommissionRateCreateDto;
import ru.suyundukov.MyProject.dto.CommissionRateDto;
import ru.suyundukov.MyProject.entity.CommissionRate;
import ru.suyundukov.MyProject.entity.CommissionRateFilter;
import ru.suyundukov.MyProject.mapper.CommissionRateMapper;
import ru.suyundukov.MyProject.mapper.CommissionRateUseCase;
import ru.suyundukov.MyProject.others.AbstractExternalController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tes")
@Tag(name = "Контроллер ставки комисии")
public class CommissionRateController extends AbstractExternalController {
    private static final Logger log = LoggerFactory.getLogger(CommissionRateController.class);
    private final CommissionRateInbound commissionRateInbound;
    private final CommissionRateMapper commissionRateMapper;

    @GetMapping("/{afId}")
    @Operation(description = "Получение данных Ставки комисии по afId")
    public CommissionRateDto getCommissionRateByAfId(@PathVariable String afId) {
        CommissionRate commissionRate = commissionRateInbound.getByAfId(afId);
        return commissionRateMapper.mapToDto(commissionRate);
    }

    @GetMapping("/byLmId")
    @Operation(description = "Получение данных Ставки комисии по lmId")
    public CommissionRateDto getCommissionRateByLmId(@RequestHeader("lmId") String lmId) {
        CommissionRate commissionRate = commissionRateInbound.getByLmId(lmId);
        return commissionRateMapper.mapToDto(commissionRate);
    }


    @PostMapping
    @Operation(description = "Создание Ставки Комисии")
    public CommissionRateDto createCommissionRate(@RequestBody CommissionRateCreateDto commissionRateCreateDto) {
//        if (commissionRateCreateDto == null){
//            return ResponseEntity.badRequest().body(null);
//        }
        CommissionRate commissionRate = commissionRateMapper.mapToDomain(commissionRateCreateDto);
        CommissionRateUseCase.validateDeadline(commissionRate);
        CommissionRate savedCommissionRate = commissionRateInbound.createCommissionRate(commissionRate);
        CommissionRateUseCase.validateDeadline(commissionRate);
        return commissionRateMapper.mapToDto(savedCommissionRate);
    }

    @PostMapping("/filter")
    @Operation(description = "Фильтрация ставок комиссии по заданным параметрам")
    public ResponseEntity<List<CommissionRateDto>> findByFilter(@RequestBody CommissionRateFilter filter) {
        if (filter == null){
            return ResponseEntity.badRequest().body(null);
        }
        List<CommissionRate> commissionRates;
        try {
            commissionRates = commissionRateInbound.findByFilter(filter);
        }catch (Exception e){
            log.error("Ошибка по фильтрации ставок комисии: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        List<CommissionRateDto> commissionRateDtos = commissionRates.stream()
                .map(commissionRateMapper::mapToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(commissionRateDtos);
    }
}