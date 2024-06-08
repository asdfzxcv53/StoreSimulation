package com.example.store.mapper;

import com.example.store.dto.LotteryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LotteryMapper {
    public List<LotteryDto> SelectAllLottery();
    public void InsertLottery(LotteryDto lotteryDto);
}
