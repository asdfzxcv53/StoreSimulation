package com.example.store.mapper;

import com.example.store.dto.DiscardListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiscardListMapper {
    public List<DiscardListDto> SelectAllDiscardList();
    public void InsertDiscardList(DiscardListDto discardListDto);
}
