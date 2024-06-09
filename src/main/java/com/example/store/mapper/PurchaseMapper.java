package com.example.store.mapper;

import com.example.store.dto.PurchaseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseMapper {
    public List<PurchaseDto> SelectAllPurchase();
    public void InsertPurchase(PurchaseDto purchaseDto);
    public void UpdatePurchase(PurchaseDto purchaseDto);
    public PurchaseDto SelectPurchaseByDateCode(String purchaseDate, String purchaseCode);
}
