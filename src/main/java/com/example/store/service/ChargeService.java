package com.example.store.service;

import com.example.store.dto.ChargeDto;
import com.example.store.mapper.ChargeMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ChargeService {
    private final ChargeMapper chargeMapper;
    private final CodeSequence codeSequence;

    @Autowired
    public ChargeService(ChargeMapper chargeMapper, CodeSequence codeSequence) {
        this.chargeMapper = chargeMapper;
        this.codeSequence = codeSequence;
    }

    public List<ChargeDto> SelectAllCharge(){
        return chargeMapper.SelectAllCharge();
    }

    public void InsertCharge(ChargeDto chargeDto){
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        chargeDto.setPayDate(formattedDate);
        chargeDto.setChargeCode(codeSequence.generateChargeCode());
        chargeMapper.InsertCharge(chargeDto);
    }
}
