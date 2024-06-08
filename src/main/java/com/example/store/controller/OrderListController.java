package com.example.store.controller;

import com.example.store.dto.OrderListDto;
import com.example.store.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/orderlist")
public class OrderListController {
    private final OrderListService orderListService;

    @Autowired
    public OrderListController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }

    @GetMapping
    public List<OrderListDto> SelectAllOrderList(){
        return orderListService.SelectAllOrderList();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertOrderList(@RequestBody OrderListDto orderListDto){
        orderListService.InsertOrderList(orderListDto);
        return ResponseEntity.ok().build();
    }
}
