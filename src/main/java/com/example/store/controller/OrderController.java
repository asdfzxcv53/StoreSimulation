package com.example.store.controller;

import com.example.store.dto.OrderDto;
import com.example.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> SelectAllOrder(){
        return orderService.SelectAllOrder();
    }

    @PostMapping
    public ResponseEntity<?> InsertOrder(@RequestBody OrderDto orderDto){
        orderService.InsertOrder(orderDto);
        return ResponseEntity.ok().build();
    }
}
