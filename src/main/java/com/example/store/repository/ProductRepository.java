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

    public List<ProductDto> SelectProduct(){
        return jdbcTemplate.query("select * from product", new BeanPropertyRowMapper<>(ProductDto.class));
    }

    public List<ProductDto> SelectProductByName(String name){
        String sql = "select * from product where PRODUCT_NAME = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(ProductDto.class));
    }

    public void InsertProduct(ProductDto product){
        String sql = "insert into product values (?, ?, ?)";
        jdbcTemplate.update(sql, product.getProduct_no(), product.getProduct_name(), product.getProduct_price());
    }

    public void DeleteProduct(int id){
        String sql = "delete from product where PRODUCT_NO = ?";
        jdbcTemplate.update(sql, id);
    }
}
