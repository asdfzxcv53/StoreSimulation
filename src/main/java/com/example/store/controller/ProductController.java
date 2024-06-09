package com.example.store.controller;

import com.example.store.dto.ProductDto;
import com.example.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> SelectAllProducts() {

        return productService.SelectAllProducts();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertProduct(@RequestBody ProductDto productDto){
        productService.InsertProduct(productDto);
        return ResponseEntity.ok("Product added successfully");
    }

    @PostMapping("/update")
    public ResponseEntity<?> UpdateProduct(@RequestBody ProductDto productDto){
        productService.UpdateProduct(productDto);
        return ResponseEntity.ok("Product updated successfully");
    }

    @PostMapping("/deregist")
    public ResponseEntity<?> DeleteProductByCode(@RequestBody Map<String, List<String>> productCodeMap){
        for (Map.Entry<String, List<String>> entry : productCodeMap.entrySet()) {
            for (String productCode : entry.getValue()) {
                productService.DeleteProductByCode(productCode);
            }
        }
        return ResponseEntity.ok("Product deleted successfully");
    }
}
