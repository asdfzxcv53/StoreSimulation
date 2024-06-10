package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PurchaseDto {
    private String purchaseDate;
    private String purchaseCode;
    private Long purchaseAmount;
    private Long purchaseMileage = 0L;
    private String cardAccountNo = "";
    private Long cardPurchaseAmount = 0L;
    private String voucherNo = "";
    private Long voucherPurchaseAmount = 0L;
    private String couponNo = "";
    private Long couponPurchaseAmount = 0L;
    private Long cashPurchaseAmount = 0L;
    private Long useMileage = 0L;
    private String empCode = "";
    private String membershipCode = "";
}
