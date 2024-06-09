package com.example.store.service;

import com.example.store.dto.ATMDto;
import com.example.store.mapper.ATMMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ATMService {

    private final ATMMapper atmMapper;
    private final CodeSequence codeSequence;

    @Autowired
    public ATMService(ATMMapper atmMapper, CodeSequence codeSequence){
        this.atmMapper = atmMapper;
        this.codeSequence = codeSequence;
    }

    public List<ATMDto> SelectAllATM(){
        return atmMapper.SelectAllATM();
    }

    public void InsertATM(ATMDto atmDto){
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        atmDto.setAtmUseDate(formattedDate);
        atmDto.setAtmCode(codeSequence.generateAtmCode());
        atmMapper.InsertATM(atmDto);
    }
}
