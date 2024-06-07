package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargeDto {

    private String payDate;
    private String chargeCode;
    private String instName;
    private String chargeName;
    private String payer;
    private Long payAmount;
    private String empCode;
}
