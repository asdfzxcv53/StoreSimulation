package com.example.store.mapper;

import com.example.store.dto.PurListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurListMapper {
    public List<PurListDto> SelectAllPurList();
    public void InsertPurList(PurListDto purListDto);
}
