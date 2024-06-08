package com.example.store.mapper;

import com.example.store.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public List<OrderDto> SelectAllOrder();
    public void InsertOrder(OrderDto orderDto);
}
