package com.yp.mapper;

import com.yp.JxcApplicationTests;
import com.yp.entity.Sale;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class SaleMapperTest extends JxcApplicationTests {

    @Autowired
    private SaleMapper saleMapper;
    @Test
    public void findAllSales() {
        List<Sale> saleList = saleMapper.findAllSales(4);
        for (Sale sale : saleList) {
            System.out.println(sale);
        }
    }
}