package com.example.store.service;

import com.example.store.dto.OrderDto;
import com.example.store.dto.OrderListDto;
import com.example.store.dto.OutcomeDto;
import com.example.store.mapper.OrderListMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrderListService {
    private final OrderListMapper orderListMapper;
    private final CodeSequence codeSequence;
    private final OrderService orderService;
    private final OutcomeService outcomeService;

    @Autowired
    public OrderListService(OrderListMapper orderListMapper, CodeSequence codeSequence, OrderService orderService, OutcomeService outcomeService) {
        this.orderListMapper = orderListMapper;
        this.codeSequence = codeSequence;
        this.orderService = orderService;
        this.outcomeService = outcomeService;
    }

    public List<OrderListDto> SelectAllOrderList(){
        return orderListMapper.SelectAllOrderList();
    }

    public void InsertOrderList(OrderListDto orderListDto){
        Long orderAmount = 0L;

        OrderListDto orderListDto1 = orderListDto;

        orderListDto1.setOrderDate(codeSequence.getTime());
        orderListDto1.setOrderCode(codeSequence.getOrderCode());

        orderAmount += orderListDto1.getOrderProductPrice() * orderListDto1.getOrderProductQuantity();

        System.out.println(orderListDto1);
        orderListMapper.InsertOrderList(orderListDto1);

        OutcomeDto newOutcomeDto = new OutcomeDto();
        newOutcomeDto = outcomeService.SelectOutcomeByDateCode(codeSequence.getTime(), codeSequence.getOrderCode());
        newOutcomeDto.setOutcomeAmount(orderAmount);

        System.out.println(newOutcomeDto);
        outcomeService.UpdateOutcome(newOutcomeDto);

        OrderDto newOrderDto = new OrderDto();
        newOrderDto = orderService.SelectOrderByDateCode(codeSequence.getTime(), codeSequence.getOrderCode());
        newOrderDto.setOrderAmount(orderAmount);

        System.out.println(newOrderDto);
        orderService.UpdateOrder(newOrderDto);
    }

    public void UpdateOrderList(OrderListDto orderListDto){
        orderListMapper.UpdateOrderList(orderListDto);
    }
}
