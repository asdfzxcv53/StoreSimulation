package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private String orderDate;
    private String orderCode;
    private Long orderAmount;
}
