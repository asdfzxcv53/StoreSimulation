package com.example.store.controller;

import com.example.store.dto.ReturnListDto;
import com.example.store.service.ReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/returnlist")
public class ReturnListController {
    private final ReturnListService returnListService;

    @Autowired
    public ReturnListController(ReturnListService returnListService) {
        this.returnListService = returnListService;
    }

    @GetMapping
    public List<ReturnListDto> SelectAllReturnList() {
        return returnListService.SelectAllReturnList();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertReturnList(@RequestBody List<ReturnListDto> returnListDto) {

        System.out.println(returnListDto.toString());
        for (ReturnListDto returnListDto1 : returnListDto) {

            returnListService.InsertReturnList(returnListDto1);
        }

        return ResponseEntity.ok().build();
    }
}
