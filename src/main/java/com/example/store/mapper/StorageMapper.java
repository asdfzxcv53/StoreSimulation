package com.example.store.mapper;

import com.example.store.dto.DisplayDto;
import com.example.store.dto.StorageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorageMapper {
    public List<StorageDto> SelectAllStorage();
    public StorageDto SelectStorageByCode(String productCode);
    public void InsertStorage(StorageDto storageDto);
    public void UpdateStorage(StorageDto storageDto);
    public void DeleteStorageByCode(String storageCode);
}
