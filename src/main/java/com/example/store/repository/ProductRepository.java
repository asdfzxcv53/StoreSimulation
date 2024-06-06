package com.example.store.repository;

import com.example.store.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductDto> SelectAllProduct(){
        return jdbcTemplate.query("select * from product", new BeanPropertyRowMapper<>(ProductDto.class));
    }

    public ProductDto SelectProductByCode(String productCode){
        String sql = "select * from product where PRODUCT_CODE = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ProductDto.class), productCode);
    }

    public ProductDto SelectProductByName(String productName){
        String sql = "select * from product where PRODUCT_NAME = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ProductDto.class), productName);
    }

    public void InsertProduct(ProductDto productDto){
        String sql = "insert into product values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, productDto.getProductCode(), productDto.getProductName(), productDto.getProductPrice(), productDto.getPbProduct());
    }

    public void UpdateProduct(ProductDto productDto){
        String sql = "update product set product_name = ?,product_price = ?,pb_product = ? where PRODUCT_CODE = ?";
        jdbcTemplate.update(sql, productDto.getProductName(), productDto.getProductPrice(), productDto.getPbProduct(), productDto.getProductCode());
    }

    public void DeleteProduct(String productCode){
        String sql = "delete from product where PRODUCT_CODE = ?";
        jdbcTemplate.update(sql, productCode);
    }
}
