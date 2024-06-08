package com.example.store.mapper;

import com.example.store.dto.DeliveryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    List<DeliveryDto> SelectAllDelivery();
    void InsertDelivery(DeliveryDto deliveryDto);
}
