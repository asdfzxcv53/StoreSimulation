package com.example.store.service;

import com.example.store.dto.LotteryDto;
import com.example.store.mapper.LotteryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class LotteryService {
    private final LotteryMapper lotteryMapper;

    @Autowired
    public LotteryService(LotteryMapper lotteryMapper) {
        this.lotteryMapper = lotteryMapper;
    }

    public List<LotteryDto> SelectAllLottery(){
        return lotteryMapper.SelectAllLottery();
    }

    public void InsertLottery(LotteryDto lotteryDto){
        lotteryMapper.InsertLottery(lotteryDto);
    }
}
