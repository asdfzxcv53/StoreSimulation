package com.example.store.controller;

import com.example.store.dto.ProductDto;
import com.example.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product")
@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    @ResponseBody
    public List<ProductDto> SelectAllProducts() {
        return productService.SelectAllProducts();
    }

    //@PostMapping("")

    @PostMapping("/save")
    public void InsertProduct(@RequestBody ProductDto productDto){
        productService.InsertProduct(productDto);
    }

    //@PostMapping()
}
