package com.example.store.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class ProductDto {
    private int product_no;

    private String product_name;

    private int product_price;
}
