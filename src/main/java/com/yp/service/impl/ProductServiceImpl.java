package com.yp.service.impl;

import com.yp.entity.Product;
import com.yp.enums.JxcEnum;
import com.yp.exception.JxcException;
import com.yp.mapper.ProductMapper;
import com.yp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yangpeng
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findAllProduct() {
        List<Product> productList = productMapper.selectAll();
        return productList;
    }

    @Override
    @Transactional
    public Integer updateQuantity(Integer id, Integer quantity) {
        int count = productMapper.updateQuantity(id, quantity);
        if (count!=1){
            log.error("【更新商品库存】 更新商品库存信息失败！！！");
            throw new JxcException(JxcEnum.PARAM_ERROR);
        }
        return count;
    }

    @Override
    public Integer findQuantityById(Integer id) {
        Product product = new Product();
        product.setId(id);
        Product product1 = productMapper.selectOne(product);
        if (product1==null){
            log.error("【查询商品信息】 查询商品信息失败！！！id={},product1={}",id,product1);
            throw new JxcException(JxcEnum.PARAM_ERROR);
        }
        return product1.getQuantity();
    }
}
