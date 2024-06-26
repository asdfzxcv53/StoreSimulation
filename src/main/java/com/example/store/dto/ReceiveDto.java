package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReceiveDto {
    private String orderCode;
    private String productCode;
    private Long orderProductPrice;
    private String companyCode;
    private Long receiveQuantity;
}
