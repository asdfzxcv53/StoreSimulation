package com.example.store.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StorageDto {
    private String productCode;
    private String productName;
    private Long storageQuantity;
    private Long productPrice;
    private Long productDc = 0L;
    private String pbProduct = "N";
}
