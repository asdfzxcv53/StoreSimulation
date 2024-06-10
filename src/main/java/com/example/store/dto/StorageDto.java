package com.example.store.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StorageDto {
    private String productCode;
    private String productName;
    private Long storageQuantity = 0L;
    private Long productPrice;
    private Long productDc = 0L;
    private String pbProduct = "N";
}
