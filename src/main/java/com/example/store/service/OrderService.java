package com.example.store.service;

import com.example.store.dto.*;
import com.example.store.mapper.OrderMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final CodeSequence codeSequence;
    private final OutcomeService outcomeService;

    @Autowired
    public OrderService(OrderMapper orderMapper, CodeSequence codeSequence, OutcomeService outcomeService) {
        this.orderMapper = orderMapper;
        this.codeSequence = codeSequence;
        this.outcomeService = outcomeService;
    }

    public List<OrderDto> SelectAllOrder(){
        return orderMapper.SelectAllOrder();
    }

    public void InsertOrder(){
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        String orderCode = codeSequence.generateOrderCode();

        codeSequence.setTime(formattedDate);

        //지출먼저 넣어주고
        OutcomeDto outcomeDto = new OutcomeDto();
        outcomeDto.setOutcomeCode(orderCode);
        outcomeDto.setOutcomeDate(formattedDate);
        outcomeDto.setOutcomeAmount(0L);
        System.out.println(outcomeDto);
        outcomeService.InsertOutcome(outcomeDto);

        //주문목록 넣어주기
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderCode(orderCode);
        orderDto.setOrderDate(formattedDate);
        orderDto.setOrderAmount(0L);
        System.out.println(orderDto);
        orderMapper.InsertOrder(orderDto);

    }

    public void UpdateOrder(OrderDto orderDto){
        orderMapper.UpdateOrder(orderDto);
    }

    public OrderDto SelectOrderByDateCode(String orderDate, String orderCode){
        return orderMapper.SelectOrderByDateCode(orderDate, orderCode);
    }
}
