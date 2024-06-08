package com.example.store.service;

import com.example.store.dto.DiscardListDto;
import com.example.store.mapper.DiscardListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscardListService {
    private final DiscardListMapper discardListMapper;

    @Autowired
    public DiscardListService(DiscardListMapper discardListMapper) {
        this.discardListMapper = discardListMapper;
    }

    public List<DiscardListDto> SelectAllDiscardList() {
        return discardListMapper.SelectAllDiscardList();
    }

    public void InsertDiscardList(DiscardListDto discardListDto) {
        discardListMapper.InsertDiscardList(discardListDto);
    }
}
