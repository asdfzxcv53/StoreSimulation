package com.example.store.service;

import com.example.store.controller.ReceiveController;
import com.example.store.dto.ProductDto;
import com.example.store.dto.ReceiveDto;
import com.example.store.dto.StorageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiveService {
    private final ProductService productService;
    private final StorageService storageService;

    @Autowired
    public ReceiveService(ProductService productService, StorageService storageService) {
        this.productService = productService;
        this.storageService = storageService;
    }

    public void ReceiveProduct(ReceiveDto receiveDto1){

        ProductDto productDto = productService.SelectProductByCode(receiveDto1.getProductCode());
        StorageDto storageDto = storageService.SelectStorageByCode(receiveDto1.getProductCode());
        if(storageDto == null){
            storageDto = new StorageDto();
            storageDto.setProductCode(productDto.getProductCode());
            storageDto.setProductName(productDto.getProductName());
            storageDto.setProductPrice(productDto.getProductPrice());
            storageDto.setPbProduct(productDto.getPbProduct());
            storageDto.setStorageQuantity(receiveDto1.getReceiveQuantity());

            storageService.InsertStorage(storageDto);
        }
        else{
            storageDto.setStorageQuantity(storageDto.getStorageQuantity() + receiveDto1.getReceiveQuantity());
            storageService.UpdateStorage(storageDto);
        }

    }
}
