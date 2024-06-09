package com.example.store.service;

import com.example.store.dto.*;
import com.example.store.mapper.PurListMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PurListService {
    private final PurListMapper purListMapper;
    private final DisplayService displayService;
    private final PurchaseService purchaseService;
    private final CodeSequence codeSequence;
    private final IncomeService incomeService;
    private final ProductService productService;

    Long allMileageAmount = 0L;
    Long allPurchaseAmount = 0L;

    @Autowired
    public PurListService(PurListMapper purListMapper, DisplayService displayService, PurchaseService purchaseService, CodeSequence codeSequence, IncomeService incomeService, ProductService productService) {
        this.purListMapper = purListMapper;
        this.displayService = displayService;
        this.purchaseService = purchaseService;
        this.codeSequence = codeSequence;
        this.incomeService = incomeService;
        this.productService = productService;
    }

    public List<PurListDto> SelectAllPurList(){
        return purListMapper.SelectAllPurList();
    }

    @Transactional
    public void InsertPurList(List<PurListDto> purListDtoList){
        PurchaseDto purchaseDto = purchaseService.SelectPurchaseByDateCode(purchaseService.getTime(), codeSequence.getPurchaseCode());

        allMileageAmount = 0L;
        allPurchaseAmount = 0L;

        for(PurListDto purListDto : purListDtoList) {
            ProductDto productDto = productService.SelectProductByCode(purListDto.getProductCode());

            // 기본키 지정
            purListDto.setPurchaseCode(codeSequence.getPurchaseCode());
            purListDto.setPurchaseCode(purchaseService.getTime());

            // 진열상품 개수 업데이트
            DisplayDto newDisplayDto = displayService.SelectDisplayByCode(purListDto.getProductCode());
            if (newDisplayDto.getDisplayQuantity() - purListDto.getPurchaseProductQuantity() < 0)
                throw new RuntimeException(" ? ");
            newDisplayDto.setDisplayQuantity(newDisplayDto.getDisplayQuantity() - purListDto.getPurchaseProductQuantity());
            if(purchaseDto.getEmpCode() != null){
                if(productDto.getPbProduct().equals("y")){ // 목록의 제품의 pbProduct 가 y 면
                    double productMileageTemp = productDto.getProductPrice() * 0.1;
                    long productMileage = Math.round(productMileageTemp);
                    purListDto.setAccMileage(productMileage);
                    allMileageAmount += productMileage;
                    allPurchaseAmount += productDto.getProductPrice() * purListDto.getPurchaseProductQuantity() - productMileage;
                    // 이경우에는 마일리지를 빼고 더해야하니까 여기서 더해주고
                }
            }
            // 이경우에는 마일리지가 없으니 다 더해주고
            else
                allPurchaseAmount += productDto.getProductPrice() * purListDto.getPurchaseProductQuantity();

            displayService.UpdateDisplay(newDisplayDto);
            purListMapper.InsertPurList(purListDto);

            // 하나라도 마일리지가있으면 총 구매에 총 마일리지 추가해서 업데이트
            if(purchaseDto.getEmpCode() != null && allMileageAmount > 0){
                purchaseDto.setPurchaseMileage(allMileageAmount);
            }

            //수입부분도 업데이트
            IncomeDto incomeDto = incomeService.SelectIncomeByDateCode(purListDto.getPurchaseDate(), purListDto.getPurchaseCode());
            incomeDto.setIncomeAmount(allPurchaseAmount);
            incomeService.UpdateIncome(incomeDto);

            // 구매의 총합도 업데이트
            purchaseDto.setPurchaseAmount(allPurchaseAmount);
            purchaseService.UpdatePurchase(purchaseDto);
        }
    }
    @Transactional
    public void UpdatePurList(PurListDto purListDto){
        purListMapper.UpdatePurList(purListDto);
    }
}
