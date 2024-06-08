package com.example.store.service;

import com.example.store.dto.ChargeDto;
import com.example.store.mapper.ChargeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeService {
    private final ChargeMapper chargeMapper;

    @Autowired
    public ChargeService(ChargeMapper chargeMapper) {
        this.chargeMapper = chargeMapper;
    }

    public List<ChargeDto> SelectAllCharge(){
        return chargeMapper.SelectAllCharge();
    }

    public void InsertCharge(ChargeDto chargeDto){
        chargeMapper.InsertCharge(chargeDto);
    }
}
