package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OutcomeDto {
    private String outcomeDate;
    private String outcomeCode;
    private Long outcomeAmount;
}
