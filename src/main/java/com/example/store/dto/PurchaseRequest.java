package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PurchaseRequest {
    PurchaseDto purchaseDto;
    List<PurListDto> purListDtoList;
}
