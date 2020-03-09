package com.yp.service;

import com.yp.entity.Product;

import java.util.List;

/**
 * @author yangpeng
 */
public interface ProductService {
    /**
     * 查询全部商品信息
     * @return
     */
    List<Product> findAllProduct();

    /**
     * 更新商品库存信息
     * @param id
     * @param quantity
     * @return
     */
    Integer updateQuantity(Integer id,Integer quantity);

    /**
     * 根据商品id查询商品的库存数量
     * @param id
     * @return
     */
    Integer findQuantityById(Integer id);
}
