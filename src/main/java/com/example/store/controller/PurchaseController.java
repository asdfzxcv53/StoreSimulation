package com.example.store.controller;

import com.example.store.dto.*;
import com.example.store.service.PurchaseService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;


    @Autowired
    public PurchaseController(PurchaseService purchaseService, ObjectMapper objectMapper) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<PurchaseDto> SelectAllPurchase(){
        return purchaseService.SelectAllPurchase();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertPurchase(@RequestBody List<PurchaseDto> purchaseDto){
        System.out.println("??????????");

        PurchaseDto newPurchaseDto = purchaseDto.get(0);

        System.out.println(newPurchaseDto);
        purchaseService.InsertPurchase(newPurchaseDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> UpdatePurchase(@RequestBody PurchaseDto purchaseDto){
        purchaseService.UpdatePurchase(purchaseDto);
        return ResponseEntity.ok().build();
    }
}
