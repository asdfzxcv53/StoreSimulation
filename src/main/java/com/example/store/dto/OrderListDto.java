package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderListDto {
    private String orderCode;
    private String orderDate;
    private String productCode;
    private Long orderProductQuantity;
    private Long orderProductPrice;
    private String companyCode;
}
