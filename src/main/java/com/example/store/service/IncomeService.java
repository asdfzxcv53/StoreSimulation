package com.example.store.service;

import com.example.store.dto.IncomeDto;
import com.example.store.mapper.IncomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IncomeService {
    private final IncomeMapper incomeMapper;

    @Autowired
    public IncomeService(IncomeMapper incomeMapper) {
        this.incomeMapper = incomeMapper;
    }

    public List<IncomeDto> SelectAllIncome(){
        return incomeMapper.SelectAllIncome();
    }

    public void InsertIncome(IncomeDto incomeDto){
        incomeMapper.InsertIncome(incomeDto);
    }

    public void UpdateIncome(IncomeDto incomeDto){
        incomeMapper.UpdateIncome(incomeDto);
    }

    public IncomeDto SelectIncomeByDateCode(String incomeDate, String incomeCode){
        return incomeMapper.SelectIncomeByDateCode(incomeDate,incomeCode);
    }
}
