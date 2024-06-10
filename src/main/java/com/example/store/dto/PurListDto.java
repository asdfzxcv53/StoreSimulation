package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PurListDto {
    private String purchaseDate;
    private String purchaseCode;
    private String productCode;
    private Long purchaseProductQuantity;
    private Long purchaseProductPrice;
    private Long accMileage = 0L;
}
