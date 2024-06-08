package com.example.store.mapper;

import com.example.store.dto.OutcomeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutcomeMapper {
    public List<OutcomeDto> SelectAllOutcome();
    public void InsertOutcome(OutcomeDto outcomeDto);
}