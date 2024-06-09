package com.example.store.mapper;

import com.example.store.dto.OrderListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderListMapper {
    public List<OrderListDto> SelectAllOrderList();
    public void InsertOrderList(OrderListDto orderListDto);
    public void UpdateOrderList(OrderListDto orderListDto);
}
