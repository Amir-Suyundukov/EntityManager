package ru.suyundukov.MyProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class DateRangeFilter {
    private LocalDate startDate;
    private LocalDate endDate;
}
