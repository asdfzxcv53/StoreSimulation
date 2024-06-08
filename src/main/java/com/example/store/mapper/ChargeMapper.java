package com.example.store.mapper;

import com.example.store.dto.ChargeDto;
import jdk.jfr.Name;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChargeMapper {
    public List<ChargeDto> SelectAllCharge();
    public void InsertCharge(ChargeDto charge);
}
