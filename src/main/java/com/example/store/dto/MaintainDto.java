package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaintainDto {
    private String maintainDate;
    private String maintainCode;
    private Long maintainAmount;
    private String empCode;
}
