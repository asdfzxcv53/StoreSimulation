package com.example.store.mapper;

import com.example.store.dto.MaintainDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MaintainMapper {
    public List<MaintainDto> SelectAllMaintain();
    public void InsertMaintain(MaintainDto maintainDto);
}
