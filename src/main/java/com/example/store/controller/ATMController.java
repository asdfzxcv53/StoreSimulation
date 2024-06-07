package com.example.store.controller;

import com.example.store.dto.ATMDto;
import com.example.store.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ATMController {

    private final ATMService atmService;

    @Autowired
    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @PostMapping
    public void InsertATM(@RequestBody ATMDto atmDto) {
        atmService.InsertATM(atmDto);
    }
}
