package com.example.store.controller;

import com.example.store.dto.DiscardListDto;
import com.example.store.service.DiscardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/discardlist")
public class DiscardListController {
    private final DiscardListService discardListService;

    @Autowired
    public DiscardListController(DiscardListService discardListService) {
        this.discardListService = discardListService;
    }

    @GetMapping
    public List<DiscardListDto> SelectAllDiscardList() {
        return discardListService.SelectAllDiscardList();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertDiscardList(@RequestBody DiscardListDto discardListDto) {
        discardListService.InsertDiscardList(discardListDto);
        return ResponseEntity.ok().build();
    }
}
