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
    private final OrderListService orderListService;

    @Autowired
    public OrderService(OrderMapper orderMapper, CodeSequence codeSequence, OutcomeService outcomeService, OrderListService orderListService) {
        this.orderMapper = orderMapper;
        this.codeSequence = codeSequence;
        this.outcomeService = outcomeService;
        this.orderListService = orderListService;
    }

    public List<OrderDto> SelectAllOrder(){
        return orderMapper.SelectAllOrder();
    }

    public void InsertOrder(OrderOrderListDto orderOrderListDto){
        LocalDate currentDate = LocalDate.now();

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 현재 날짜를 지정한 포맷으로 변환하여 문자열로 저장
        String formattedDate = currentDate.format(formatter);

        String orderCode = codeSequence.generateOrderCode();

        OrderDto orderDto = orderOrderListDto.getOrderDto();
        List<OrderListDto> orderListDto = orderOrderListDto.getOrderListDto();

        Long allOrderAmount = 0L;

        //지출먼저 넣어주고
        OutcomeDto outcomeDto = new OutcomeDto();
        outcomeDto.setOutcomeCode(orderCode);
        outcomeDto.setOutcomeDate(formattedDate);
        outcomeDto.setOutcomeAmount(0L);
        outcomeService.InsertOutcome(outcomeDto);

        //주문목록 넣어주기
        orderDto.setOrderCode(orderCode);
        orderDto.setOrderDate(formattedDate);
        orderDto.setOrderAmount(0L);
        orderMapper.InsertOrder(orderDto);

        //주문목록은 어케할지
        for (OrderListDto orderListDto1 : orderListDto) {
            orderListDto1.setOrderCode(orderCode);
            orderListDto1.setOrderDate(formattedDate);
            orderListService.InsertOrderList(orderListDto1);

            allOrderAmount += orderListDto1.getOrderProductPrice() * orderListDto1.getOrderProductQuantity();
        }

        outcomeDto.setOutcomeAmount(allOrderAmount);
        //outcomeService.UpdateOutcome(outcomeDto);

        orderDto.setOrderAmount(allOrderAmount);
        orderMapper.UpdateOrder(orderDto);
    }

    public void UpdateOrder(OrderDto orderDto){
        orderMapper.UpdateOrder(orderDto);
    }
}
