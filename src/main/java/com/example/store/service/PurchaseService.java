package com.example.store.service;

import com.example.store.dto.IncomeDto;
import com.example.store.dto.PurchaseDto;
import com.example.store.mapper.PurchaseMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class PurchaseService {
    private final PurchaseMapper purchaseMapper;
    private final CodeSequence codeSequence;
    private final IncomeService incomeService;
    private final PurListService purListService;

    @Autowired
    public PurchaseService(PurchaseMapper purchaseMapper, CodeSequence codeSequence, IncomeService incomeService, PurListService purListService) {
        this.purchaseMapper = purchaseMapper;
        this.codeSequence = codeSequence;
        this.incomeService = incomeService;
        this.purListService = purListService;
    }

    public List<PurchaseDto> SelectAllPurchase(){
        return purchaseMapper.SelectAllPurchase();
    }

    public void InsertPurchase(PurchaseDto purchaseDto){
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        String purchaseCode = codeSequence.generatePurchaseCode();

        //수입 넣어주고
        IncomeDto incomeDto = new IncomeDto();
        incomeDto.setIncomeCode(purchaseCode);
        incomeDto.setIncomeDate(formattedDate);
        incomeDto.setIncomeAmount(purchaseDto.getPurchaseAmount());
        incomeService.InsertIncome(incomeDto);

        //구매 넣어주고
        purchaseDto.setPurchaseCode(purchaseCode);
        purchaseDto.setPurchaseDate(formattedDate);
        purchaseMapper.InsertPurchase(purchaseDto);

        //구매목록도 넣어줘야겠지

    }

    public void UpdatePurchase(PurchaseDto purchaseDto){

        purchaseMapper.UpdatePurchase(purchaseDto);
    }
}
