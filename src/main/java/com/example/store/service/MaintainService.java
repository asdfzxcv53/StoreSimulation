package com.example.store.service;

import com.example.store.dto.IncomeDto;
import com.example.store.dto.MaintainData;
import com.example.store.dto.MaintainDto;
import com.example.store.dto.OutcomeDto;
import com.example.store.mapper.MaintainMapper;
import com.example.store.mapper.OutcomeMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class MaintainService {
    private final MaintainMapper maintainMapper;
    private final CodeSequence codeSequence;
    private final OutcomeService outcomeService;

    @Autowired
    public MaintainService(MaintainMapper maintainMapper, CodeSequence codeSequence, OutcomeService outcomeService) {
        this.maintainMapper = maintainMapper;
        this.codeSequence = codeSequence;
        this.outcomeService = outcomeService;
    }

    public List<MaintainDto> SelectAllMaintain() {
        return maintainMapper.SelectAllMaintain();
    }

    @Transactional
    public void InsertMaintain(MaintainData maintainData) {
        String typeCode = maintainData.getTypeCode();
        Long amount = maintainData.getAmount();
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        String maintainCode = codeSequence.generateMaintainCode(typeCode);


        // 지출먼저 넣어주고
        OutcomeDto outcomeDto = new OutcomeDto();
        outcomeDto.setOutcomeCode(maintainCode);
        outcomeDto.setOutcomeDate(formattedDate);
        outcomeDto.setOutcomeAmount(amount);
        outcomeService.InsertOutcome(outcomeDto);
        System.out.println(outcomeDto);

        // 유지비 나중에 넣어주고
        MaintainDto maintainDto = new MaintainDto();
        maintainDto.setMaintainCode(maintainCode);
        maintainDto.setMaintainDate(formattedDate);
        maintainDto.setMaintainAmount(amount);
        System.out.println(maintainDto);
        maintainMapper.InsertMaintain(maintainDto);
    }
}
