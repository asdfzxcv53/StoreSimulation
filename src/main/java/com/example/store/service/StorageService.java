package com.example.store.service;

import com.example.store.dto.DisplayDto;
import com.example.store.dto.StorageDto;
import com.example.store.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StorageService {
    private final StorageMapper storageMapper;
    private final DisplayService displayService;


    @Autowired
    public StorageService(StorageMapper storageMapper, DisplayService displayService) {
        this.storageMapper = storageMapper;
        this.displayService = displayService;
    }

    public List<StorageDto> SelectAllStorage(){
        return storageMapper.SelectAllStorage();
    }

    public StorageDto SelectStorageByCode(String productCode){
        return storageMapper.SelectStorageByCode(productCode);
    }

    public void InsertStorage(StorageDto storageDto){
        storageMapper.InsertStorage(storageDto);
    }

    public void UpdateStorage(StorageDto storageDto){
        storageMapper.UpdateStorage(storageDto);
    }

    public void DeleteStorageByCode(String storageCode){
        storageMapper.DeleteStorageByCode(storageCode);
    }

    @Transactional
    public void MoveDisplay(String productCode, Long amount) {

        //수량만큼 빼줌
        StorageDto storageDto = SelectStorageByCode(productCode);
        if(storageDto.getStorageQuantity() - amount < 0)
            return;

        storageDto.setStorageQuantity(storageDto.getStorageQuantity() - amount);
        UpdateStorage(storageDto);

        // 진열대에서 수량만큼 더해줌
        DisplayDto displayDto = displayService.SelectDisplayByCode(productCode);
        if(displayDto == null) {
            displayDto.setProductCode(productCode);
            displayDto.setProductName(storageDto.getProductName());
            displayDto.setProductDc(storageDto.getProductDc());
            displayDto.setProductPrice(storageDto.getProductPrice());
            displayDto.setPbProduct(storageDto.getPbProduct());
            displayDto.setDisplayQuantity(amount);
            displayDto.setPbProduct("N");
            displayService.InsertDisplay(displayDto);
        }
        else{
            displayDto.setDisplayQuantity(displayDto.getDisplayQuantity() + amount);
            displayService.UpdateDisplay(displayDto);
        }
    }

}
