package com.example.store.service;

import com.example.store.dto.ReturnListDto;
import com.example.store.mapper.ReturnListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ReturnListService {
    private final ReturnListMapper returnListMapper;

    @Autowired
    public ReturnListService(ReturnListMapper returnListMapper) {
        this.returnListMapper = returnListMapper;
    }

    public List<ReturnListDto> SelectAllReturnList(){
        return returnListMapper.SelectAllReturnList();
    }

    public void InsertReturnList(ReturnListDto returnListDto){
        returnListMapper.InsertReturnList(returnListDto);
    }
}
