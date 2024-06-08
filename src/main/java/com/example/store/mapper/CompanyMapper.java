package com.example.store.mapper;

import com.example.store.dto.CompanyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
    public List<CompanyDto> SelectAllCompany();
    public void InsertCompany(CompanyDto companyDto);
}
