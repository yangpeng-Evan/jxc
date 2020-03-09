package com.yp.service;

import com.yp.JxcApplicationTests;
import com.yp.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest extends JxcApplicationTests {

    @Autowired
    private ProductService productService;
    @Test
    public void findAllProduct() {
        List<Product> productList = productService.findAllProduct();
        assertNotNull(productList);
    }

    @Test
    public void findQuantityById(){
        Integer count = productService.findQuantityById(1);
        System.out.println(count);
    }
}