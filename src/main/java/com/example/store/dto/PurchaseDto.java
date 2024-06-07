package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDto {
    private String purchaseDate;
    private String purchaseCode;
    private Long purchaseAmount;
    private String purchaseMileage;
    private String cardAccountNo;
    private Long cardPurchaseAmount;
    private String voucherNo;
    private Long voucherPurchaseAmount;
    private String couponNo;
    private Long couponPurchaseAmount;
    private Long cashPurchaseAmount;
    private String useMileage;
    private String empCode;
    private String membershipCode;
}
