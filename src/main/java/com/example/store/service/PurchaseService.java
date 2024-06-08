package com.example.store.service;

import com.example.store.dto.PurchaseDto;
import com.example.store.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PurchaseService {
    private final PurchaseMapper purchaseMapper;

    @Autowired
    public PurchaseService(PurchaseMapper purchaseMapper) {
        this.purchaseMapper = purchaseMapper;
    }

    public List<PurchaseDto> SelectAllPurchase(){
        return purchaseMapper.SelectAllPurchase();
    }

    public void InsertPurchase(PurchaseDto purchaseDto){
        purchaseMapper.InsertPurchase(purchaseDto);
    }
}
