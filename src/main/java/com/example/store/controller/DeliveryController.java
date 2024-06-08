package com.example.store.controller;

import com.example.store.dto.DeliveryDto;
import com.example.store.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryController {
    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<DeliveryDto> SelectAllDelivery() {
        return deliveryService.SelectAllDelivery();
    }

    @PostMapping
    public ResponseEntity<?> InsertDelivery(@RequestBody DeliveryDto deliveryDto){
        deliveryService.InsertDelivery(deliveryDto);
        return ResponseEntity.ok().build();
    }
}
