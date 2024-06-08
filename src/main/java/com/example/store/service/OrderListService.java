package com.example.store.service;

import com.example.store.dto.OrderListDto;
import com.example.store.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrderListService {
    private final OrderListMapper orderListMapper;

    @Autowired
    public OrderListService(OrderListMapper orderListMapper) {
        this.orderListMapper = orderListMapper;
    }

    public List<OrderListDto> SelectAllOrderList(){
        return orderListMapper.SelectAllOrderList();
    }

    public void InsertOrderList(OrderListDto orderListDto){
        orderListMapper.InsertOrderList(orderListDto);
    }
}
