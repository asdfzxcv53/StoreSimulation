package com.example.store.mapper;

import com.example.store.dto.OutcomeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OutcomeMapper {
    public List<OutcomeDto> SelectAllOutcome();
    public void InsertOutcome(OutcomeDto outcomeDto);
    public OutcomeDto SelectOutcomeByDateCode(@Param("outcomeDate") String outcomeDate,@Param("outcomeCode") String outcomeCode);
    public void UpdateOutcome(OutcomeDto outcomeDto);
}
