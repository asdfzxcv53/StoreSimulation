package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderOrderListDto {
    private OrderDto orderDto;
    private List<OrderListDto> orderListDto;
}
