package com.example.store.mapper;

import com.example.store.dto.DisplayDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DisplayMapper {
    public List<DisplayDto> SelectAllDisplay();
    public void InsertDisplay(DisplayDto displayDto);
}
