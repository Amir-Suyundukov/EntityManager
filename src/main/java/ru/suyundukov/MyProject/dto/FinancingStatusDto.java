package ru.suyundukov.MyProject.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Data
public class FinancingStatusDto {
    private String code;
    private String value;
}
