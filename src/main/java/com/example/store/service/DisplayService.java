package com.example.store.service;

import com.example.store.dto.DisplayDto;
import com.example.store.mapper.DisplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DisplayService {
    private final DisplayMapper displayMapper;

    @Autowired
    public DisplayService(DisplayMapper displayMapper) {
        this.displayMapper = displayMapper;
    }

    public List<DisplayDto> SelectAllDisplay() {
        return displayMapper.SelectAllDisplay();
    }

    public DisplayDto SelectDisplayByCode(String productCode) {
        return displayMapper.SelectDisplayByCode(productCode);
    }

    public void InsertDisplay(DisplayDto displayDto) {
        displayMapper.InsertDisplay(displayDto);
    }

    public void UpdateDisplay(DisplayDto displayDto) {
        displayMapper.UpdateDisplay(displayDto);
    }

    public void DeleteDisplayByCode(String displayCode) {
        displayMapper.DeleteDisplayByCode(displayCode);
    }

}
