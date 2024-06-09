package com.example.store.controller;

import com.example.store.dto.ATMDto;
import com.example.store.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atm")
public class ATMController {

    private final ATMService atmService;

    @Autowired
    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping
    public List<ATMDto> SelectAllATM() {
        return atmService.SelectAllATM();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertATM(@RequestBody ATMDto atmDto) {
        System.out.println(atmDto);
        atmService.InsertATM(atmDto);
        return ResponseEntity.ok().build();
    }
}
