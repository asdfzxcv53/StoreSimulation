package com.example.store.controller;

import com.example.store.dto.PurListDto;
import com.example.store.service.PurListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/purlist")
public class PurListController {
    private final PurListService purListService;

    @Autowired
    public PurListController(PurListService purListService) {
        this.purListService = purListService;
    }
    @GetMapping
    public List<PurListDto> SelectAllPurList(){
        return purListService.SelectAllPurList();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertPurList(@RequestBody PurListDto purListDto){
        purListService.InsertPurList(purListDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> UpdatePurList(@RequestBody PurListDto purListDto){
        purListService.UpdatePurList(purListDto);
        return ResponseEntity.ok().build();
    }
}
