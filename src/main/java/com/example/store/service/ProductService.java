package com.example.store.service;

import com.example.store.dto.ProductDto;
import com.example.store.mapper.ProductMapper;
import com.example.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public List<ProductDto> SelectAllProducts() {
        return productMapper.SelectAllProduct();
    }

    @Transactional
    public ProductDto SelectProductByCode(String productCode) {
        return productRepository.SelectProductByCode(productCode);
    }

    @Transactional
    public ProductDto SelectProductByName(String productName) {
        return productRepository.SelectProductByName(productName);
    }

    @Transactional
    public void InsertProduct(ProductDto productDto) {
        productRepository.InsertProduct(productDto);
    }

    @Transactional
    public void UpdateProduct(ProductDto productDto) {
        productRepository.UpdateProduct(productDto);
    }

    @Transactional
    public void DeleteProductByCode(String productCode) {
        productRepository.DeleteProduct(productCode);
    }

    @Transactional
    public int CountProduct() {
        return productMapper.CountProduct();
    }
}
