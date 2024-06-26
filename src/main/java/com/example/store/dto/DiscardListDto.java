package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiscardListDto {
    private String discardDate;
    private String discardTypeCode;
    private String productCode;
    private Long discardQuantity;
    private String empCode;
}
