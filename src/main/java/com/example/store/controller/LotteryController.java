package com.example.store.controller;

import com.example.store.dto.LotteryDto;
import com.example.store.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/lottery")
public class LotteryController {
    private final LotteryService lotteryService;

    @Autowired
    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping
    public List<LotteryDto> SelectAllLottery(){
        return lotteryService.SelectAllLottery();
    }

    @PostMapping("regist")
    public ResponseEntity<?> InsertLottery(@RequestBody LotteryDto lotteryDto){
        lotteryService.InsertLottery(lotteryDto);
        return ResponseEntity.ok().build();
    }
}
