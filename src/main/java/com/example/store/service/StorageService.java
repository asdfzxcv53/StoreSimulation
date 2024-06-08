package com.example.store.service;

import com.example.store.dto.StorageDto;
import com.example.store.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StorageService {
    private final StorageMapper storageMapper;

    @Autowired
    public StorageService(StorageMapper storageMapper) {
        this.storageMapper = storageMapper;
    }

    public List<StorageDto> SelectAllStorage(){
        return storageMapper.SelectAllStorage();
    }

    public void InsertStorage(StorageDto storageDto){
        storageMapper.InsertStorage(storageDto);
    }

}
