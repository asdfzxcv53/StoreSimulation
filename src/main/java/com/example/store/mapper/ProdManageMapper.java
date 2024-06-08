package com.example.store.mapper;

import com.example.store.dto.ProdManageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProdManageMapper {
    public List<ProdManageDto> SelectAllProdManage();
    public void InsertProdManage(ProdManageDto prodManageDto);
}
