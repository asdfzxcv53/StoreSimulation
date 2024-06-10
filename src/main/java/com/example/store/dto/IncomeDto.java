package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IncomeDto {
    private String incomeDate;
    private String incomeCode;
    private Long incomeAmount;
}
