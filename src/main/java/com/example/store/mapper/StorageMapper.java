package com.example.store.mapper;

import com.example.store.dto.StorageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorageMapper {
    public List<StorageDto> SelectAllStorage();
    public void InsertStorage(StorageDto storageDto);
}
