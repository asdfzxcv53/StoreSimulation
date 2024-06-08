package com.example.store.controller;

import com.example.store.dto.OutcomeDto;
import com.example.store.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/outcome")
public class OutcomeController {
    private final OutcomeService outcomeService;

    @Autowired
    public OutcomeController(OutcomeService outcomeService) {
        this.outcomeService = outcomeService;
    }

    @GetMapping
    public List<OutcomeDto> SelectAllOutcome(){
        return outcomeService.SelectAllOutcome();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertOutcome(@RequestBody OutcomeDto outcomeDto){
        outcomeService.InsertOutcome(outcomeDto);
        return ResponseEntity.ok().build();
    }
}
