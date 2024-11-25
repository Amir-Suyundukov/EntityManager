package ru.suyundukov.MyProject.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Простой справочник")
public class EnumDictionaryDto<T extends Enum<T>> {
    @Schema(description = "Код", example = "CODE")
    private T code;
    @Schema(description = "Значение", example = "Value")
    private String value;
//    @Schema(description = "хз", example = "isVatSubject")
//    private Boolean isVatSubject;
}