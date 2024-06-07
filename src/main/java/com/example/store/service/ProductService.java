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

    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Transactional
    public List<ProductDto> SelectAllProducts() {
        return productMapper.SelectAllProduct();
    }

    @Transactional
    public ProductDto SelectProductByCode(String productCode) {
        return productMapper.SelectProductByCode(productCode);
    }

    @Transactional
    public ProductDto SelectProductByName(String productName) {
        return productMapper.SelectProductByName(productName);
    }

    @Transactional
    public void InsertProduct(ProductDto productDto) {
        productMapper.InsertProduct(productDto);
    }

    @Transactional
    public void UpdateProduct(ProductDto productDto) {
        productMapper.UpdateProduct(productDto);
    }

    @Transactional
    public void DeleteProductByCode(String productCode) {
        productMapper.DeleteProduct(productCode);
    }

    @Transactional
    public int CountProduct() {
        return productMapper.CountProduct();
    }
}
