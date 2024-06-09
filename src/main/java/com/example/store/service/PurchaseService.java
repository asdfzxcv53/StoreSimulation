package com.example.store.service;

import com.example.store.dto.*;
import com.example.store.mapper.PurchaseMapper;
import com.example.store.sequence.CodeSequence;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class PurchaseService {
    private final PurchaseMapper purchaseMapper;
    private final CodeSequence codeSequence;
    private final IncomeService incomeService;

    @Getter
    @Setter
    private String time;

    @Autowired
    public PurchaseService(PurchaseMapper purchaseMapper, CodeSequence codeSequence, IncomeService incomeService) {
        this.purchaseMapper = purchaseMapper;
        this.codeSequence = codeSequence;
        this.incomeService = incomeService;
    }

    public List<PurchaseDto> SelectAllPurchase(){
        return purchaseMapper.SelectAllPurchase();
    }

    public PurchaseDto SelectPurchaseByDateCode(String purchaseDate, String PurchaseCode){
        return purchaseMapper.SelectPurchaseByDateCode(purchaseDate, PurchaseCode);
    };

    @Transactional
    public void InsertPurchase(PurchaseDto purchaseDto){
        LocalDate currentDate = LocalDate.now();

        System.out.println(purchaseDto);
        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        String purchaseCode = codeSequence.generatePurchaseCode();

        this.setTime(formattedDate);

        Long allMileageAmount = 0L;
        Long allPurchaseAmount = 0L;

        //수입 넣어주고
        IncomeDto incomeDto = new IncomeDto();
        incomeDto.setIncomeCode(purchaseCode);
        incomeDto.setIncomeDate(formattedDate);
        incomeDto.setIncomeAmount(0L);
        incomeService.InsertIncome(incomeDto);

        //구매 넣어주고
        purchaseDto.setPurchaseCode(purchaseCode);
        purchaseDto.setPurchaseDate(formattedDate);
        purchaseDto.setPurchaseAmount(0L);
        purchaseMapper.InsertPurchase(purchaseDto);
    }

    public void UpdatePurchase(PurchaseDto purchaseDto){

        purchaseMapper.UpdatePurchase(purchaseDto);
    }
}
