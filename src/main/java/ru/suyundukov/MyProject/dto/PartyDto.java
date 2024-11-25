package ru.suyundukov.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.suyundukov.MyProject.entity.PartyType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartyDto {
    private String afId;
    private PartyType type;
    private String userName;
    private String shortName;
    private String inn;
    private String mainPinEq;
}
