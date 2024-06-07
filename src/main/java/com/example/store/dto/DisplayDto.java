package com.example.store.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisplayDto {
    private String productCode;
    private String productName;
    private Long displayQuantity;
    private Long productPrice;
    private Long productDc;
    private String pbProduct;
}
