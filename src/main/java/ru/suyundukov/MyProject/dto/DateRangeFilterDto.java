package ru.suyundukov.MyProject.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Schema()
@DateRange(start = "dateFrom" , end = "dateTo")
public class DateRangeFilterDto {
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
