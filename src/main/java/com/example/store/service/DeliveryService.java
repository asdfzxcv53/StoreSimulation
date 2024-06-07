package com.example.store.service;

import com.example.store.dto.DeliveryDto;
import com.example.store.mapper.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    private DeliveryMapper deliveryMapper;

    @Autowired
    public DeliveryService(DeliveryMapper deliveryMapper) {
        this.deliveryMapper = deliveryMapper;
    }

    public void InsertDelivery(DeliveryDto deliveryDto) {
        deliveryMapper.InsertDelivery(deliveryDto);
    }
}
