package com.yp.mapper;

import com.yp.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yangpeng
 */
public interface ProductMapper extends Mapper<Product> {


    /**
     * 根据商品id更新商品信息，减少库存
     * @param id
     * @param quantity
     * @return
     */
    @Update("update product set quantity = quantity - #{quantity} where id = #{id}")
    int updateQuantity(@Param("id") Integer id, @Param("quantity") Integer quantity);
}
