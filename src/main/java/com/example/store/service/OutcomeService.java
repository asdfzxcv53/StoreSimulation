package com.example.store.service;

import com.example.store.dto.OutcomeDto;
import com.example.store.mapper.OrderMapper;
import com.example.store.mapper.OutcomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OutcomeService {
    private final OutcomeMapper outcomeMapper;
    private final OrderMapper orderMapper;

    @Autowired
    public OutcomeService(OutcomeMapper outcomeMapper, OrderMapper orderMapper) {
        this.outcomeMapper = outcomeMapper;
        this.orderMapper = orderMapper;
    }

    public List<OutcomeDto> SelectAllOutcome(){
        return outcomeMapper.SelectAllOutcome();
    }

    public void InsertOutcome(OutcomeDto outcomeDto){
        outcomeMapper.InsertOutcome(outcomeDto);
    }

    public OutcomeDto SelectOutcomeByDateCode(String orderDate, String orderCode) {
        return outcomeMapper.SelectOutcomeByDateCode(orderDate, orderCode);
    }
    public void UpdateOutcome(OutcomeDto outcomeDto){
        outcomeMapper.UpdateOutcome(outcomeDto);
    }
}
