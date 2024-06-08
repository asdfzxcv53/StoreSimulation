package com.example.store.controller;

import com.example.store.dto.CompanyDto;
import com.example.store.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyDto> SelectAllCompany(){
        return companyService.SelectAllCompany();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertCompany(@RequestBody CompanyDto companyDto){
        companyService.InsertCompany(companyDto);
        return ResponseEntity.ok().build();
    }
}
