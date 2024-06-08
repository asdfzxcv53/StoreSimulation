package com.example.store.mapper;

import com.example.store.dto.IncomeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IncomeMapper {
    public List<IncomeDto> SelectAllIncome();
    public void InsertIncome(IncomeDto incomeDto);
}
