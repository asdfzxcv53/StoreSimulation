package com.example.store.controller;

import com.example.store.dto.OrderDto;
import com.example.store.dto.OrderListDto;
import com.example.store.dto.OrderOrderListDto;
import com.example.store.dto.ReceiveDto;
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

    @GetMapping("/regist")
    public ResponseEntity<?> InsertOrder(){
        orderService.InsertOrder();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> UpdateOrder(@RequestBody OrderDto orderDto){
        orderService.UpdateOrder(orderDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/receive") // 제품을 납품받는 경우
    public ResponseEntity<?> ReceiveOrder(@RequestBody ReceiveDto receiveDto) {

        return ResponseEntity.ok().build();
    }
}
