package com.example.store.mapper;

import com.example.store.dto.PurListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurListMapper {
    public List<PurListDto> SelectAllPurList();
    public void InsertPurList(PurListDto purListDto);
    public void UpdatePurList(PurListDto purListDto);
    public PurListDto SelectPurListByKey(@Param("purchaseDate")String purchaseDate, @Param("purchaseCode") String purchaseCode, @Param("productCode") String productCode);
}
