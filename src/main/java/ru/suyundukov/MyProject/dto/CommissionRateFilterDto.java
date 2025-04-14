package ru.suyundukov.MyProject.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Фильтр для поиска коммисий")
public class CommissionRateFilterDto {
    @Schema(description = "AFID комисии")
    private String afID;
    @Schema(description = "Дата начала")
    @Valid
    private DateRangeFilterDto startDate;
    @Schema(description = "Дата оканчания")
    @Valid
    private DateRangeFilterDto endDate;
}
