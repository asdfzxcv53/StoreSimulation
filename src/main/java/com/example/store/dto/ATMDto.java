package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ATMDto {

    private String atmUseDate;
    private String atmCode;
    private String dnwTypeCode;
    private String atmBankName;
    private String atmAccountNo;
    private Long dnwAmount;
    private String empCode;
}
