package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurListDto {
    private String purchaseDate;
    private String purchaseCode;
    private String productCode;
    private Long purchaseProductQuantity;
    private Long purchaseProductPrice;
    private String accMileage;
}
