package com.example.store.service;

import com.example.store.dto.ProductDto;
import com.example.store.mapper.ProductMapper;
import com.example.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    public List<ProductDto> SelectAllProducts() {
        return productRepository.SelectAllProduct();
    }

    public ProductDto SelectProductByCode(String productCode) {
        return productRepository.SelectProductByCode(productCode);
    }

    public ProductDto SelectProductByName(String productName) {
        return productRepository.SelectProductByName(productName);
    }

    public void InsertProduct(ProductDto productDto) {
        productRepository.InsertProduct(productDto);
    }

    public void UpdateProduct(ProductDto productDto) {
        productRepository.UpdateProduct(productDto);
    }

    public void DeleteProductByCode(String productCode) {
        productRepository.DeleteProduct(productCode);
    }

    public int CountProduct() {
        return productMapper.CountProduct();
    }
}
