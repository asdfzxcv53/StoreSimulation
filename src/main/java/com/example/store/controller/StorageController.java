package com.example.store.controller;

import com.example.store.dto.StorageDto;
import com.example.store.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/storage")
public class StorageController {
    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    public List<StorageDto> SelectAllStorage(){
        return storageService.SelectAllStorage();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertStorage(@RequestBody StorageDto storageDto){
        storageService.InsertStorage(storageDto);
        return ResponseEntity.ok().build();
    }
}
