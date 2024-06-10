package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaintainDto {
    private String maintainDate;
    private String maintainCode;
    private Long maintainAmount;
    private String empCode = "";
}
