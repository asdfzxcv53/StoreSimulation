package com.example.store.service;

import com.example.store.dto.ProductDto;
import com.example.store.mapper.ProductMapper;
import com.example.store.repository.ProductRepository;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductMapper productMapper;
    private final CodeSequence codeSequence;

    @Autowired
    public ProductService(ProductMapper productMapper, CodeSequence codeSequence) {
        this.productMapper = productMapper;
        this.codeSequence = new CodeSequence();
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
        productDto.setProductCode(codeSequence.generateProductCode());
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
