package com.example.store.sequence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class CodeSequence {
    private static int employeeCode = 0;
    private static int chargeCode = 0;
    private static int atmCode = 0;
    private static int deliveryCode = 0;
    private static int lotteryCode = 0;
    private static int purchaseCode = 0;
    private static int maintainCode = 0;
    private static int orderCode = 0;
    private static int companyCode = 0;
    private static int membershipCode = 0;
    private static int productCode = 0;
    private static final int MAX_CODE_VALUE = 999999;

    @Getter
    @Setter
    private String time;

    //아래 3개가 지출에 대한 코드

    public String getPurchaseCode(){
        return String.format("%02d%04d", 12, purchaseCode);
    }

    public String getOrderCode(){
        return String.format("%02d%04d", 02, orderCode);
    }

    public synchronized String generateProductCode() {
        if (productCode >= MAX_CODE_VALUE) {
            productCode = 0;
        }
        productCode++;
        return String.format("%04d", productCode);
    }


    public synchronized String generateEmployeeCode() {
        if (employeeCode >= MAX_CODE_VALUE) {
            employeeCode = 0;
        }
        employeeCode++;
        return String.format("%02d%04d", 00, employeeCode);
    }

    public synchronized String generateMaintainCode(String typeCode) {
        if (maintainCode >= MAX_CODE_VALUE) {
            maintainCode = 0;
        }
        maintainCode++;
        if (typeCode.equals("전기세")) {return String.format("%02d%02d%02d", 01, 00, maintainCode);}
        else if (typeCode.equals("임대료")) {return String.format("%02d%02d%02d", 01, 01, maintainCode);}
        else if (typeCode.equals("인건비")) {return String.format("%02d%02d%02d", 01, 02, maintainCode);}
        else return "";
    }

    public synchronized String generateOrderCode() {
        if (orderCode >= MAX_CODE_VALUE) {
            orderCode = 0;
        }
        orderCode++;
        return String.format("%02d%04d", 02, orderCode);
    }

    //아래 2개가 수입에 대한 코드

    public synchronized String generateDeliveryCode() {
        if (deliveryCode >= MAX_CODE_VALUE) {
            deliveryCode = 0;
        }
        deliveryCode++;
        return String.format("%02d%04d", 10, deliveryCode);
    }

    public synchronized String generateLottaryCode() {
        if (lotteryCode >= MAX_CODE_VALUE) {
            lotteryCode = 0;
        }
        lotteryCode++;
        return String.format("%02d%04d", 11, lotteryCode);
    }

    public synchronized String generatePurchaseCode() {
        if (purchaseCode >= MAX_CODE_VALUE) {
            purchaseCode = 0;
        }
        purchaseCode++;
        return String.format("%02d%04d", 12, purchaseCode);
    }

    public synchronized String generateChargeCode() {
        if (chargeCode >= MAX_CODE_VALUE) {
            chargeCode = 0;
        }
        chargeCode++;
        return String.format("%02d%04d", 20, chargeCode);
    }

    public synchronized String generateAtmCode() {
        if (atmCode >= MAX_CODE_VALUE) {
            atmCode = 0;
        }
        atmCode++;
        return String.format("%02d%04d", 21, atmCode);
    }

    public synchronized String generateCompanyCode() {
        if (companyCode >= MAX_CODE_VALUE) {
            companyCode = 0;
        }
        companyCode++;
        return String.format("%04d", companyCode);
    }
    public synchronized String generateMembershipCode() {
        if (membershipCode >= MAX_CODE_VALUE) {
            membershipCode = 0;
        }
        membershipCode++;
        return String.format("%04d", membershipCode);
    }

    public void ResetCode(){
        chargeCode = 0;
        atmCode = 0;
        deliveryCode = 0;
        lotteryCode = 0;
        purchaseCode = 0;
        maintainCode = 0;
        orderCode = 0;
    }
}
