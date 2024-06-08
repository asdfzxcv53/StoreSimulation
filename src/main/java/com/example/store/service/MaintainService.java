package com.example.store.service;

import com.example.store.dto.MaintainDto;
import com.example.store.mapper.MaintainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MaintainService {
    private final MaintainMapper maintainMapper;

    @Autowired
    public MaintainService(MaintainMapper maintainMapper) {
        this.maintainMapper = maintainMapper;
    }

    public List<MaintainDto> SelectAllMaintain() {
        return maintainMapper.SelectAllMaintain();
    }

    public void InsertMaintain(MaintainDto maintainDto) {
        maintainMapper.InsertMaintain(maintainDto);
    }
}
