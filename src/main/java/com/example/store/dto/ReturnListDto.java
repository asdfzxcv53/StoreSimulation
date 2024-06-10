package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReturnListDto {
    private String purchaseDate;
    private String purchaseCode;
    private String productCode;
    private Long returnQuantity;
    private Long returnPrice;
    private String returnDate;
}
