package com.example.store.mapper;

import com.example.store.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    public List<OrderDto> SelectAllOrder();
    public void InsertOrder(OrderDto orderDto);
    public void UpdateOrder(OrderDto orderDto);
    public OrderDto SelectOrderByDateCode(@Param("orderDate") String orderDate, @Param("orderCode") String orderCode);
}
