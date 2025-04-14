package ru.suyundukov.MyProject.entity;

import lombok.Getter;
import lombok.Setter;
import ru.suyundukov.MyProject.dto.DateRangeFilterDto;

@Getter
@Setter
public class CommissionRateFilter {
    private String afId;
    private String lmId;
    private CommissionRateStatus status;
//    private DateRangeFilter startDate;
//    private DateRangeFilter endDate;
}
