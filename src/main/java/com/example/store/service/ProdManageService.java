package com.example.store.service;

import com.example.store.dto.ProdManageDto;
import com.example.store.mapper.ProdManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProdManageService {
    private final ProdManageMapper prodManageMapper;

    @Autowired
    public ProdManageService(ProdManageMapper prodManageMapper) {
        this.prodManageMapper = prodManageMapper;
    }

    public List<ProdManageDto> SelectAllProdManage() {
        return prodManageMapper.SelectAllProdManage();
    }

    public void InsertProdManage(ProdManageDto prodManageDto) {
        prodManageMapper.InsertProdManage(prodManageDto);
    }
}
