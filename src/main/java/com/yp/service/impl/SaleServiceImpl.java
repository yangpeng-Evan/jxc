package com.yp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yp.entity.Sale;
import com.yp.entity.User;
import com.yp.enums.JxcEnum;
import com.yp.exception.JxcException;
import com.yp.form.SaleForm;
import com.yp.mapper.SaleMapper;
import com.yp.service.ProductService;
import com.yp.service.SaleService;
import com.yp.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yangpeng
 */
@Service
@Slf4j
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private ProductService productService;
    @Override
    @Transactional
    public void add(Sale sale) {
        //获取用户userid并封装到sale中
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sale.setUserId(user.getId());
        //计算商品总价并封装
        BigDecimal price = sale.getPrice();
        Integer quantity = sale.getQuantity();
        BigDecimal totalPrice = price.multiply(new BigDecimal(quantity));
        sale.setTotalPrice(totalPrice);
        //执行添加销售记录信息
        int count = saleMapper.insertSelective(sale);
        //判断是否添加成功
        if (count!=1){
            log.error("【添加销售记录】 添加销售记录信息失败！！！sale={}",sale);
            throw new JxcException(JxcEnum.PARAM_ERROR);
        }
        //调用productService减少商品库存数量
        productService.updateQuantity(sale.getProductId(), sale.getQuantity());
    }

    @Override
    public PageVO findAllSalesByPages(Integer page, Integer size, Integer flag) {
        //开启分页
        PageHelper.startPage(page, size);
        //调用mapper查询数据
        List<Sale> list = saleMapper.findAllSales(flag);
        //将list分装到pageInfo中
        PageInfo<Sale> pageInfo = new PageInfo<>(list);
        //封装数据到pageVo中
        PageVO pageVO = new PageVO();
        pageVO.setTotalCount(pageInfo.getTotal());
        pageVO.setList(list);
        pageVO.setPageSize(pageInfo.getPageSize());
        pageVO.setTotalPage(pageInfo.getPages());
        pageVO.setCurrentPage(pageInfo.getPageNum());
        return pageVO;
    }
}
