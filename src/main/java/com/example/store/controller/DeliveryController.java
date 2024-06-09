package com.example.store.controller;

import com.example.store.dto.DeliveryDto;
import com.example.store.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
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

    @PostMapping("/regist")
    public ResponseEntity<?> InsertDelivery(@RequestBody DeliveryDto deliveryDto){
        System.out.println(deliveryDto);

        deliveryService.InsertDelivery(deliveryDto);
        return ResponseEntity.ok().build();
    }
}
