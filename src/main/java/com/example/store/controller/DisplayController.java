package com.example.store.controller;

import com.example.store.dto.DisplayDto;
import com.example.store.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/display")
public class DisplayController {
    private final DisplayService displayService;

    @Autowired
    public DisplayController(DisplayService displayService) {
        this.displayService = displayService;
    }

    @GetMapping
    public List<DisplayDto> SelectAllDisplay() {
        return displayService.SelectAllDisplay();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertDisplay(@RequestBody DisplayDto displayDto) {
        displayService.InsertDisplay(displayDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> UpdateDisplay(@RequestBody DisplayDto displayDto) {
        displayService.UpdateDisplay(displayDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deregist")
    public ResponseEntity<?> DeleteDisplayByCode(@RequestBody Map<String, List<String>> displayCodeMap) {
        for (Map.Entry<String, List<String>> entry : displayCodeMap.entrySet()) {
            for (String displayCode : entry.getValue()) {
                displayService.DeleteDisplayByCode(displayCode);
            }
        }
        return ResponseEntity.ok().build();
    }
}
