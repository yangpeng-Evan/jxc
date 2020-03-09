package com.yp.service;

import com.github.pagehelper.PageInfo;
import com.yp.entity.Sale;
import com.yp.form.SaleForm;
import com.yp.vo.PageVO;

/**
 * @author yangpeng
 */
public interface SaleService {

    /**
     * 保存销售记录
     * @param sale
     */
    void add(Sale sale);

    /**
     * 分页查询销售记录信息
     * @param page
     * @param size
     * @param flag
     * @return
     */
    PageVO findAllSalesByPages(Integer page, Integer size, Integer flag);
}
