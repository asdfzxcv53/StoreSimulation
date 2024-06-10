package com.example.store.service;

import com.example.store.dto.IncomeDto;
import com.example.store.dto.PurListDto;
import com.example.store.dto.ReturnListDto;
import com.example.store.mapper.ReturnListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ReturnListService {
    private final ReturnListMapper returnListMapper;
    private final PurListService purListService;
    private final IncomeService incomeService;

    @Autowired
    public ReturnListService(ReturnListMapper returnListMapper, PurListService purListService, IncomeService incomeService) {
        this.returnListMapper = returnListMapper;
        this.purListService = purListService;
        this.incomeService = incomeService;
    }

    public List<ReturnListDto> SelectAllReturnList(){
        return returnListMapper.SelectAllReturnList();
    }

    public void InsertReturnList(ReturnListDto returnListDto){
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);


        // 반품목록에 날짜와 가격을 넣고 인서트
        returnListDto.setReturnDate(formattedDate);


        PurListDto purListDto = purListService.SelectPurListByKey(returnListDto.getPurchaseDate(), returnListDto.getPurchaseCode(), returnListDto.getProductCode());

        System.out.println(purListDto);

        //반품하는것만큼 뺀다
        purListDto.setPurchaseProductQuantity(purListDto.getPurchaseProductQuantity() - returnListDto.getReturnQuantity());
        purListService.UpdatePurList(purListDto);

        System.out.println(returnListDto);
        returnListDto.setReturnPrice(purListDto.getPurchaseProductPrice());

        System.out.println(returnListDto);
        returnListMapper.InsertReturnList(returnListDto);


        // 반품한거를 수입에서 다시 빼서 업데이트
        IncomeDto incomeDto = incomeService.SelectIncomeByDateCode(returnListDto.getPurchaseDate(), returnListDto.getPurchaseCode());
        incomeDto.setIncomeAmount(incomeDto.getIncomeAmount() - returnListDto.getReturnPrice() * returnListDto.getReturnQuantity());
        incomeService.UpdateIncome(incomeDto);
    }
}
