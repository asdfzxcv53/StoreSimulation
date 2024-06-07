package com.example.store.mapper;

import com.example.store.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public int CountProduct();
    public List<ProductDto> SelectAllProduct();
    public ProductDto SelectProductByCode(String productCode);
    public ProductDto SelectProductByName(String productName);
    public void InsertProduct(ProductDto productDto);
    public void UpdateProduct(ProductDto productDto);
    public void DeleteProduct(String productCode);
}
