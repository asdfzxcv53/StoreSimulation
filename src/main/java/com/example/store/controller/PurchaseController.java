package com.example.store.controller;

import com.example.store.dto.PurchaseDto;
import com.example.store.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<PurchaseDto> SelectAllPurchase(){
        return purchaseService.SelectAllPurchase();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertPurchase(@RequestBody PurchaseDto purchaseDto){
        purchaseService.InsertPurchase(purchaseDto);
        return ResponseEntity.ok().build();
    }
}
