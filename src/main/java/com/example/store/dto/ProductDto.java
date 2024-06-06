package com.example.store.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class ProductDto {
    private String productCode;

    private String productName;

    private Long productPrice;

    private String pbProduct;
}
