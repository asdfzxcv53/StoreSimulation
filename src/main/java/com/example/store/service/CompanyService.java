package com.example.store.service;

import com.example.store.dto.CompanyDto;
import com.example.store.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyService(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    public List<CompanyDto> SelectAllCompany(){
        return companyMapper.SelectAllCompany();
    }

    public void InsertCompany(CompanyDto companyDto){
        companyMapper.InsertCompany(companyDto);
    }
}
