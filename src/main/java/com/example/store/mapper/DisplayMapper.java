package com.example.store.mapper;

import com.example.store.dto.DisplayDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DisplayMapper {
    public List<DisplayDto> SelectAllDisplay();
    public DisplayDto SelectDisplayByCode(String productCode);
    public void InsertDisplay(DisplayDto displayDto);
    public void UpdateDisplay(DisplayDto displayDto);
    public void DeleteDisplayByCode(String displayCode);

}
