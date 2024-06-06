package com.example.store.service;

import com.example.store.dto.ProductDto;
import com.example.store.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAllProducts() {
        return productMapper.getAllProducts();
    }
}
