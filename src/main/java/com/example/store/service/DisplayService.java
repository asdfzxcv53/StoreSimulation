package com.example.store.service;

import com.example.store.dto.DisplayDto;
import com.example.store.dto.ProductDto;
import com.example.store.dto.SelectDto;
import com.example.store.dto.SelectedDto;
import com.example.store.mapper.DisplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DisplayService {
    private final DisplayMapper displayMapper;
    private final ProductService productService;

    @Autowired
    public DisplayService(DisplayMapper displayMapper, ProductService productService) {
        this.displayMapper = displayMapper;
        this.productService = productService;
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

    public List<SelectedDto> SelectDisplay(SelectDto selectDto){
        ProductDto productDto = productService.SelectProductByCode(selectDto.getProductCode());
        SelectedDto selectedDto = new SelectedDto();
        selectedDto.setProductCode(productDto.getProductCode());
        selectedDto.setProductName(productDto.getProductName());
        selectedDto.setProductPrice(productDto.getProductPrice());

        List<SelectedDto> selectedDtos = new ArrayList<>();
        selectedDtos.add(selectedDto);
        return selectedDtos;
    }
}
