package com.example.store.service;

import com.example.store.dto.CompanyDto;
import com.example.store.mapper.CompanyMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyMapper companyMapper;
    private final CodeSequence codeSequence;

    @Autowired
    public CompanyService(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
        this.codeSequence = new CodeSequence();
    }

    public List<CompanyDto> SelectAllCompany(){
        return companyMapper.SelectAllCompany();
    }

    public void InsertCompany(CompanyDto companyDto){
        companyDto.setCompanyCode(codeSequence.generateCompanyCode());
        companyMapper.InsertCompany(companyDto);
    }

    public void DeleteCompanyByCode(String companyCode){
        companyMapper.DeleteCompanyByCode(companyCode);
    }

    public void UpdateCompany(CompanyDto companyDto){
        companyMapper.UpdateCompany(companyDto);
    }
}
