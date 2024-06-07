package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdManage {
    private String manageDate;
    private String manageTypeCode;
    private String productCode;
    private Long errorQuantity;
    private String errorReason;
    private String empCode;
}
