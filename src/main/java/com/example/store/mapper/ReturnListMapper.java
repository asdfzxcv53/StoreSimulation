package com.example.store.mapper;

import com.example.store.dto.ReturnListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReturnListMapper {
    public List<ReturnListDto> SelectAllReturnList();
    public void InsertReturnList(ReturnListDto returnListDto);
}
