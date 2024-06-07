package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnListDto {
    private String purchaseDate;
    private String purchaseCode;
    private String productCode;
    private Long returnQuantity;
    private Long returnPrice;
    private String returnDate;
}
