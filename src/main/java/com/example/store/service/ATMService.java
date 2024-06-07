package com.example.store.service;

import com.example.store.dto.ATMDto;
import com.example.store.mapper.ATMMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ATMService {

    private final ATMMapper atmMapper;

    @Autowired
    public ATMService(ATMMapper atmMapper){
        this.atmMapper = atmMapper;
    }

    public void InsertATM(ATMDto atmDto){
        atmMapper.InsertATM(atmDto);
    }
}
