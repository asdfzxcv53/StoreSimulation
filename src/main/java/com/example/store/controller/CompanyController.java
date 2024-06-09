package com.example.store.controller;

import com.example.store.dto.CompanyDto;
import com.example.store.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyDto> SelectAllCompany() {
        return companyService.SelectAllCompany();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertCompany(@RequestBody CompanyDto companyDto) {
        companyService.InsertCompany(companyDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deregist")
    public ResponseEntity<?> DeleteCompanyByCode(@RequestBody Map<String, List<String>> companyCodeMap) {
        for (Map.Entry<String, List<String>> entry : companyCodeMap.entrySet()) {
            for (String companyCode : entry.getValue()) {
                companyService.DeleteCompanyByCode(companyCode);
            }
        }
        return ResponseEntity.ok().build();
    }


    @PostMapping("/update")
    public ResponseEntity<?> UpdateCompany(@RequestBody CompanyDto companyDto) {
        companyService.UpdateCompany(companyDto);
        return ResponseEntity.ok().build();
    }
}
