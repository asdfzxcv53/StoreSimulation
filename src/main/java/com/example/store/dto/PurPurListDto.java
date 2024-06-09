package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PurPurListDto {
    private PurchaseDto purchaseDto;
    private List<PurListDto> purListDto;
}
