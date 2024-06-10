package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProdManageDto {
    private String manageDate;
    private String manageTypeCode;
    private String productCode;
    private Long errorQuantity;
    private String errorReason;
    private String empCode;
}
