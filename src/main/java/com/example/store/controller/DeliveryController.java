package com.example.store.controller;

import com.example.store.dto.DeliveryDto;
import com.example.store.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public void InsertDelivery(DeliveryDto deliveryDto){
        deliveryService.InsertDelivery(deliveryDto);
    }
}
