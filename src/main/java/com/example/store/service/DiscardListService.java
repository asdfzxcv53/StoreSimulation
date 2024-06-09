package com.example.store.service;

import com.example.store.dto.*;
import com.example.store.mapper.DiscardListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DiscardListService {
    private final DiscardListMapper discardListMapper;
    private final DisplayService displayService;
    private final StorageService storageService;

    @Autowired
    public DiscardListService(DiscardListMapper discardListMapper, DisplayService displayService, StorageService storageService) {
        this.discardListMapper = discardListMapper;
        this.displayService = displayService;
        this.storageService = storageService;
    }

    public List<DiscardListDto> SelectAllDiscardList() {
        return discardListMapper.SelectAllDiscardList();
    }

    @Transactional
    public void InsertDiscardList(List<DiscardListDto> discardListDto) {
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        for(DiscardListDto discardListDto1 : discardListDto) {

            if(discardListDto1.getDiscardQuantity()==0)
                continue;

            discardListDto1.setDiscardDate(formattedDate);

            System.out.println(discardListDto1);

            discardListMapper.InsertDiscardList(discardListDto1);

            if(discardListDto1.getDiscardTypeCode().equals("D")){
                DisplayDto newDisplayDto = displayService.SelectDisplayByCode(discardListDto1.getProductCode());
                if(newDisplayDto.getDisplayQuantity() - discardListDto1.getDiscardQuantity() <= 0)
                    throw new RuntimeException("Display quantity is insufficient for product code: " + discardListDto1.getProductCode());
                newDisplayDto.setDisplayQuantity(newDisplayDto.getDisplayQuantity() - discardListDto1.getDiscardQuantity());
                displayService.UpdateDisplay(newDisplayDto);
            }

            else if (discardListDto1.getDiscardTypeCode().equals("S")){
                StorageDto newStorageDto = storageService.SelectStorageByCode(discardListDto1.getProductCode());
                if(newStorageDto.getStorageQuantity() - discardListDto1.getDiscardQuantity() <= 0)
                    throw new RuntimeException("Display quantity is insufficient for product code: " + discardListDto1.getProductCode());
                newStorageDto.setStorageQuantity(newStorageDto.getStorageQuantity() - discardListDto1.getDiscardQuantity());
                storageService.UpdateStorage(newStorageDto);
            }
        }
    }
}
