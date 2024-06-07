package com.example.store.mapper;

import com.example.store.dto.ATMDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ATMMapper {
    public List<ATMDto> SelectAllATM();
    public void InsertATM(ATMDto atmDto);
}
