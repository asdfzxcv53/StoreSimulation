package com.example.store.mapper;

import com.example.store.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM PRODUCT")
    List<ProductDto> getAllProducts();
}
