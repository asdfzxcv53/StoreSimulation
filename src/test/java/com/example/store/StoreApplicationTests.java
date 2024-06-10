package com.example.store;

import com.example.store.dto.IncomeDto;
import com.example.store.dto.ProductDto;
import com.example.store.dto.PurListDto;
import com.example.store.dto.PurchaseDto;
import com.example.store.service.IncomeService;
import com.example.store.service.ProductService;
import com.example.store.service.PurListService;
import com.example.store.service.PurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.store.mapper.ProductMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class StoreApplicationTests {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PurListService purListService;
    @Autowired
    private IncomeService incomeService;

    @Test
    public void ProductInsert(){
        ProductDto productDto = new ProductDto();
        productDto.setProductCode("0001");
        productDto.setProductName("신라면");
        productDto.setProductPrice(1000L);
        productDto.setPbProduct("N");

        productService.InsertProduct(productDto);
    }

    @Test
    @Transactional
    public void PurchaseInsert(){
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setPurchaseDate("20240610");
        purchaseDto.setPurchaseCode("PC123456789");
        purchaseDto.setPurchaseAmount(150000L);
        purchaseDto.setPurchaseMileage(1500L);
        purchaseDto.setCardAccountNo("1234-5678-9012");
        purchaseDto.setCardPurchaseAmount(100000L);
        purchaseDto.setVoucherNo("VCH987654321");
        purchaseDto.setVoucherPurchaseAmount(20000L);
        purchaseDto.setCouponNo("CPN54321");
        purchaseDto.setCouponPurchaseAmount(5000L);
        purchaseDto.setCashPurchaseAmount(25000L);
        purchaseDto.setUseMileage(1000L);
        purchaseDto.setEmpCode("000001");
        purchaseDto.setMembershipCode("");
        System.out.println(purchaseDto);

        purchaseService.InsertPurchase(purchaseDto);
        //List<PurchaseDto> purchaseDtoList = purchaseService.SelectAllPurchase();
        //System.out.println(purchaseDtoList);

        System.out.println("?????????????");
        PurListDto purListDto = new PurListDto();

        purListDto.setPurchaseCode("120001");
        purListDto.setPurchaseProductQuantity(1L);
        purListDto.setPurchaseProductPrice(1000L);
        purListDto.setProductCode("0001");
        purListDto.setAccMileage(0L);

        List<PurListDto> purListDtoList = new ArrayList<>();
        purListDtoList.add(purListDto);

        purListService.InsertPurList(purListDtoList);

        PurchaseDto pd = new PurchaseDto();
        pd = purchaseService.SelectAllPurchase().get(0);
        System.out.println(pd);

        IncomeDto id = new IncomeDto();
        id = incomeService.SelectAllIncome().get(0);
        System.out.println(id);
    }

    @Test
    public void PurListInsert(){

    }
}
