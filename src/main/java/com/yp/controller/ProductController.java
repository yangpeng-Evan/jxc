package com.yp.controller;

import com.yp.entity.Product;
import com.yp.enums.JxcEnum;
import com.yp.service.ProductService;
import com.yp.util.R;
import com.yp.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangpeng
 */
@RestController
@RequestMapping("/product")
@Api(tags = "商品模块")
@Slf4j
@CrossOrigin(allowCredentials = "true")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    @ApiOperation(value = "获取商品列表接口")

    public ResultVO productList(){
        List<Product> productList = productService.findAllProduct();
        return R.ok(productList);
    }

    @GetMapping("/quantity/{id}")
    @ApiOperation(value = "查询商品库存接口")
    @ApiImplicitParam(name = "id",value = "商品id")
    public ResultVO findQuantityById(@PathVariable Integer id){
        Integer quantity = productService.findQuantityById(id);
        if (quantity==null){
            log.info("【商品功能】查询商品库存失败！！！id={}",id);
            return R.error(JxcEnum.PARAM_ERROR);
        }
        return R.ok(quantity);
    }
}
