package com.example.store.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DisplayDto {
    private String productCode;
    private String productName;
    private Long displayQuantity = 0L;
    private Long productPrice;
    private Long productDc = 0L;
    private String pbProduct = "N";
    private String giftProduct = "";
}
