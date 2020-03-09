package com.yp.service;

import com.yp.JxcApplicationTests;
import com.yp.entity.Sale;
import com.yp.vo.PageVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SaleServiceTest extends JxcApplicationTests {
    @Autowired
    private SaleService saleService;

    @Test
    public void add() {
        Sale sale = new Sale();
        sale.setProductId(1);
        sale.setPrice(new BigDecimal(10));
        sale.setQuantity(10);
        saleService.add(sale);
    }

    @Test
    public void findAllSaleByPage(){
        PageVO pageVo = saleService.findAllSalesByPages(1, 5, 4);
        System.out.println(pageVo.getCurrentPage());
        System.out.println(pageVo.getList());
        System.out.println(pageVo.getPageSize());
        System.out.println(pageVo.getTotalCount());
        System.out.println(pageVo.getTotalPage());
    }
}