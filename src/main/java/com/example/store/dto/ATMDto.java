package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ATMDto {

    private String atmUseDate;
    private String atmCode;
    private String dnwTypeCode;
    private String atmAccountNo;
    private Long dnwAmount;
    private String empCode;
}
