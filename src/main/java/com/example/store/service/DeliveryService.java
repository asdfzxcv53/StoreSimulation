package com.example.store.service;

import com.example.store.dto.DeliveryDto;
import com.example.store.dto.IncomeDto;
import com.example.store.mapper.DeliveryMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DeliveryService {
    private final DeliveryMapper deliveryMapper;
    private final CodeSequence codeSequence;
    private final IncomeService incomeService;

    @Autowired
    public DeliveryService(DeliveryMapper deliveryMapper, CodeSequence codeSequence, IncomeService incomeService) {
        this.deliveryMapper = deliveryMapper;
        this.codeSequence = codeSequence;
        this.incomeService = incomeService;
    }

    public List<DeliveryDto> SelectAllDelivery() {
        return deliveryMapper.SelectAllDelivery();
    }

    @Transactional
    public void InsertDelivery(DeliveryDto deliveryDto) {
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        String deliveryCode = codeSequence.generateDeliveryCode();
        IncomeDto incomeDto = new IncomeDto();

        //수입 먼저 넣어주고
        incomeDto.setIncomeCode(deliveryCode);
        incomeDto.setIncomeDate(formattedDate);
        incomeDto.setIncomeAmount(deliveryDto.getDeliveryAmount());
        incomeService.InsertIncome(incomeDto);

        //delivery 넣어주고
        deliveryDto.setDeliveryCode(deliveryCode);
        deliveryDto.setDeliveryDate(formattedDate);
        deliveryMapper.InsertDelivery(deliveryDto);
    }
}
