package com.example.store.controller;

import com.example.store.dto.ProdManageDto;
import com.example.store.service.ProdManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/prodmanage")
public class ProdManageController {
    private final ProdManageService prodManageService;

    @Autowired
    public ProdManageController(ProdManageService prodManageService) {
        this.prodManageService = prodManageService;
    }

    @GetMapping
    public List<ProdManageDto> SelectAllProdManage(){
        return prodManageService.SelectAllProdManage();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertProdManage(@RequestBody ProdManageDto prodManageDto){
        prodManageService.InsertProdManage(prodManageDto);
        return ResponseEntity.ok().build();
    }
}
