package com.example.store.service;

import com.example.store.dto.OutcomeDto;
import com.example.store.mapper.OutcomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OutcomeService {
    private final OutcomeMapper outcomeMapper;

    @Autowired
    public OutcomeService(OutcomeMapper outcomeMapper) {
        this.outcomeMapper = outcomeMapper;
    }

    public List<OutcomeDto> SelectAllOutcome(){
        return outcomeMapper.SelectAllOutcome();
    }

    public void InsertOutcome(OutcomeDto outcomeDto){
        outcomeMapper.InsertOutcome(outcomeDto);
    }
}
