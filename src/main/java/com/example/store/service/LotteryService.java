package com.example.store.service;

import com.example.store.dto.IncomeDto;
import com.example.store.dto.LotteryDto;
import com.example.store.mapper.LotteryMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class LotteryService {
    private final LotteryMapper lotteryMapper;
    private final CodeSequence codeSequence;
    private final IncomeService incomeService;

    @Autowired
    public LotteryService(LotteryMapper lotteryMapper, CodeSequence codeSequence, IncomeService incomeService) {
        this.lotteryMapper = lotteryMapper;
        this.codeSequence = codeSequence;
        this.incomeService = incomeService;
    }

    public List<LotteryDto> SelectAllLottery(){
        return lotteryMapper.SelectAllLottery();
    }

    @Transactional
    public void InsertLottery(LotteryDto lotteryDto){
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        String lotteryCode = codeSequence.generateLottaryCode();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            // 랜덤한 두 자리 수 생성
            int randomNumber = random.nextInt(90) + 10;
            // 두 자리 숫자를 문자열로 변환하여 더하기
            sb.append(String.format("%02d", randomNumber));
        }

        //수입먼저 넣어주고
        IncomeDto incomeDto = new IncomeDto();
        incomeDto.setIncomeCode(lotteryCode);
        incomeDto.setIncomeDate(formattedDate);
        incomeDto.setIncomeAmount(1000L);
        incomeService.InsertIncome(incomeDto);

        //복권넣어주기
        lotteryDto.setLotteryCode(lotteryCode);
        lotteryDto.setLotterySaleDate(formattedDate);
        lotteryDto.setLotteryNo(sb.toString());
        lotteryMapper.InsertLottery(lotteryDto);
    }
}
