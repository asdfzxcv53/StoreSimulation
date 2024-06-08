package com.example.store.controller;

import com.example.store.dto.MaintainDto;
import com.example.store.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/maintain")
public class MaintainController {
    private final MaintainService maintainService;

    @Autowired
    public MaintainController(MaintainService maintainService) {
        this.maintainService = maintainService;
    }

    @GetMapping
    public List<MaintainDto> SelectAllMaintain() {
        return maintainService.SelectAllMaintain();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertMaintain(@RequestBody MaintainDto maintainDto) {
        maintainService.InsertMaintain(maintainDto);
        return ResponseEntity.ok().build();
    }
}
