package com.example.store.controller;

import com.example.store.dto.StorageDto;
import com.example.store.service.DisplayService;
import com.example.store.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/storage")
public class StorageController {
    private final StorageService storageService;
    private final DisplayService displayService;

    @Autowired
    public StorageController(StorageService storageService, DisplayService displayService) {
        this.storageService = storageService;
        this.displayService = displayService;
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

    @PostMapping("/update")
    public ResponseEntity<?> UpdateStorage(@RequestBody StorageDto storageDto){
        storageService.UpdateStorage(storageDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deregist")
    public ResponseEntity<?> DeleteStorageByCode(@RequestBody Map<String,List<String>> storageCodeMap){
        for (Map.Entry<String,List<String>> entry : storageCodeMap.entrySet()){
            for (String storageCode : entry.getValue()){
                storageService.DeleteStorageByCode(storageCode);
            }
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/movedisplay")    // 창고에서 진열대로
    public ResponseEntity<?> MoveDisplay(@RequestBody List<Map<String, Long>> moveData){
        moveData.forEach(map -> {
            map.forEach((key, value) -> {
                storageService.MoveDisplay(key, value);
            });
        });
        return ResponseEntity.ok().build();
    }
}
