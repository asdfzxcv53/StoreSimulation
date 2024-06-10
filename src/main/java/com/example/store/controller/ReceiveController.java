package com.example.store.controller;

import com.example.store.dto.ReceiveDto;
import com.example.store.service.ReceiveOrderService;
import com.example.store.service.ReceiveService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/receive")
public class ReceiveController {

    private final ReceiveService receiveService;

    public ReceiveController(ReceiveService receiveService){
        this.receiveService = receiveService;
    }

    // 제품코드랑 수량을 받아온다.
    @PostMapping("/regist")
    public void ReceiveProduct(@RequestBody ReceiveDto receiveDto){
        System.out.println(receiveDto.toString());
        receiveService.ReceiveProduct(receiveDto);

    }
}
