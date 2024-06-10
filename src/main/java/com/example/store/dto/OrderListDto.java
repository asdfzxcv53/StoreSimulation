package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderListDto {
    private String orderCode;
    private String orderDate;
    private String productCode;
    private Long orderProductQuantity;
    private Long orderProductPrice;
    private String companyCode;
}
