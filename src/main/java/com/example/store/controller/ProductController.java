package com.example.store.controller;

import com.example.store.dto.ProductDto;
import com.example.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //@PostMapping("")

    @PostMapping("/regist")
    public ResponseEntity<?> InsertProduct(@RequestBody ProductDto productDto){
        productService.InsertProduct(productDto);
        return ResponseEntity.ok("Product added successfully");
    }
}
