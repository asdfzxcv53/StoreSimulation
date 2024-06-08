package com.example.store.controller;

import com.example.store.dto.ChargeDto;
import com.example.store.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/charge")
public class ChargeController {
    private final ChargeService chargeService;

    @Autowired
    public ChargeController(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @GetMapping
    public List<ChargeDto> SelectAllCharge() {
        return chargeService.SelectAllCharge();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertCharge(@RequestBody ChargeDto chargeDto) {
        chargeService.InsertCharge(chargeDto);
        return ResponseEntity.ok().build();
    }
}
