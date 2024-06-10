package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SelectedDto {
    private String productCode;
    private String productName;
    private Long productPrice;
}
