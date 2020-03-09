package com.yp.mapper;

import com.yp.entity.Sale;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yangpeng
 */
public interface SaleMapper extends Mapper<Sale> {


    /**
     * 查询全部的销售数据信息
     * @return
     */
    List<Sale> findAllSales(@Param("flag") Integer flag);
}
