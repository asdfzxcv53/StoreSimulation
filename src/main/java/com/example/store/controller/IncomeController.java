package com.example.store.controller;

import com.example.store.dto.IncomeDto;
import com.example.store.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/income")
public class IncomeController {
    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping
    public List<IncomeDto> SelectAllIncome(){
        return incomeService.SelectAllIncome();
    }

    @PostMapping("regist")
    public ResponseEntity<?> InsertIncome(@RequestBody IncomeDto incomeDto){
        incomeService.InsertIncome(incomeDto);
        return ResponseEntity.ok().build();
    }
}
