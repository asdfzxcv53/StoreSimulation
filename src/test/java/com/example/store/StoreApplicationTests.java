package com.example.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.store.mapper.ProductMapper;


@SpringBootTest
class StoreApplicationTests {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void product(){
        int a = productMapper.CountProduct();
        System.out.println(a);
    }
}
