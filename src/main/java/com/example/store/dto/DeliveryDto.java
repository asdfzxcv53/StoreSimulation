package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDto {
    private String deliveryDate;
    private String deliveryCode;
    private String receiver;
    private String sender;
    private String source;
    private String dest;
    private String deliveryContent;
    private Long deliveryAmount;
    private String currentStatus;
    private String empCode;
}
