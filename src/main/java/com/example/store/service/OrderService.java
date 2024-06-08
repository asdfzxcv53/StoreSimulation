package com.example.store.service;

import com.example.store.dto.OrderDto;
import com.example.store.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrderService {
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> SelectAllOrder(){
        return orderMapper.SelectAllOrder();
    }

    public void InsertOrder(OrderDto orderDto){
        orderMapper.InsertOrder(orderDto);
    }
}
