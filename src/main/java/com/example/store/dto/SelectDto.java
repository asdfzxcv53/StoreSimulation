package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SelectDto {
    String productCode;
    Long purchaseProductQuantity;
}
