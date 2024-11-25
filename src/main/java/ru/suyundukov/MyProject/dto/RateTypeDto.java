package ru.suyundukov.MyProject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class RateTypeDto {
    private String code;
    private String value;
}
