package com.example.store.mapper;

import com.example.store.dto.DeliveryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryMapper {
    void InsertDelivery(DeliveryDto deliveryDto);
}
