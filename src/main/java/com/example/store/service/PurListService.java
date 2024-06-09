package com.example.store.service;

import com.example.store.dto.PurListDto;
import com.example.store.dto.PurchaseDto;
import com.example.store.mapper.PurListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PurListService {
    private final PurListMapper purListMapper;

    @Autowired
    public PurListService(PurListMapper purListMapper) {
        this.purListMapper = purListMapper;
    }

    public List<PurListDto> SelectAllPurList(){
        return purListMapper.SelectAllPurList();
    }

    public void InsertPurList(PurListDto purListDto){
        purListMapper.InsertPurList(purListDto);
    }

    public void UpdatePurList(PurListDto purListDto){
        purListMapper.UpdatePurList(purListDto);
    }
}
