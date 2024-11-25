package ru.suyundukov.MyProject.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class CommissionRateStatusDto {
    private String code;
    private String value;
}
