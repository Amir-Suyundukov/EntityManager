package ru.suyundukov.MyProject.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FinancingStatus {
    FUNDED("FUNDED"),
    UNFUNDED("UNFUNDED");
    private final String value;
}
