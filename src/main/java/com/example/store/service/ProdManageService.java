package com.example.store.service;

import com.example.store.dto.DisplayDto;
import com.example.store.dto.ProdManageDto;
import com.example.store.dto.StorageDto;
import com.example.store.mapper.ProdManageMapper;
import com.example.store.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ProdManageService {
    private final ProdManageMapper prodManageMapper;
    private final DisplayService displayService;
    private final StorageService storageService;

    @Autowired
    public ProdManageService(ProdManageMapper prodManageMapper, DisplayService displayService, StorageService storageService) {
        this.prodManageMapper = prodManageMapper;
        this.displayService = displayService;
        this.storageService = storageService;
    }

    public List<ProdManageDto> SelectAllProdManage() {
        return prodManageMapper.SelectAllProdManage();
    }

    @Transactional
    public void InsertProdManage(ProdManageDto prodManageDto) {
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        prodManageDto.setManageDate(formattedDate);
        prodManageMapper.InsertProdManage(prodManageDto);

        if(prodManageDto.getManageTypeCode().equals("D")){
            DisplayDto newDisplayDto = displayService.SelectDisplayByCode(prodManageDto.getProductCode());
            Long newAmount = newDisplayDto.getDisplayQuantity();
            newAmount += prodManageDto.getErrorQuantity();
            if(newAmount < 0){
                throw new RuntimeException();
            }
            newDisplayDto.setDisplayQuantity(newAmount);
            displayService.UpdateDisplay(newDisplayDto);
        }
        else if(prodManageDto.getManageTypeCode().equals("S")){
            StorageDto newStorageDto = storageService.SelectStorageByCode(prodManageDto.getProductCode());
            Long newAmount = newStorageDto.getStorageQuantity();
            newAmount += prodManageDto.getErrorQuantity();
            if(newAmount < 0){
                throw new RuntimeException();
            }
            newStorageDto.setStorageQuantity(newAmount);
            storageService.UpdateStorage(newStorageDto);
        }
    }
}
