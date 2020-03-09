package com.yp.controller;

import com.yp.entity.Sale;
import com.yp.enums.JxcEnum;
import com.yp.form.SaleForm;
import com.yp.service.SaleService;
import com.yp.util.R;
import com.yp.vo.PageVO;
import com.yp.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 销售信息功能
 * @author yangpeng
 */
@RestController
@RequestMapping("/sale")
@Api(tags = "商品销售数据模块")
@Slf4j
@CrossOrigin(allowCredentials = "true")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/add")
    @ApiOperation(value = "添加销售记录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "prodictId",value = "商品id"),
            @ApiImplicitParam(name = "price",value = "商品价格"),
            @ApiImplicitParam(name = "quantity",value = "商品数量")
        })
    public ResultVO saleAdd(@Valid SaleForm saleForm, BindingResult bindingResult, HttpServletRequest req){
        String remoteAddr = req.getRemoteAddr();
        String remoteHost = req.getRemoteHost();
        log.error(remoteAddr + "..." + remoteHost);
//        校验参数
        if (bindingResult.hasErrors()){
            log.info("【销售记录】 添加销售记录失败！！！saleForm={}",saleForm);
            return R.error(JxcEnum.PARAM_ERROR);
        }
        //封装数据
        Sale sale = new Sale();
        sale.setPrice(saleForm.getPrice());
        sale.setQuantity(saleForm.getQuantity());
        sale.setProductId(saleForm.getProductId());
        //调用service添加数据
        try {
            saleService.add(sale);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("【添加销售数据】 添加销售数据失败！！！sale={},saleForm={}",sale,saleForm);
            return R.error(JxcEnum.PARAM_ERROR);
        }
        //返回数据
        return R.ok();
    }


    @GetMapping("/list")
    @ApiOperation(value = "分页查询商品销售数据并排序接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "当前第几页"),
            @ApiImplicitParam(name = "pageSize",value = "当前页显示条数"),
            @ApiImplicitParam(name = "flag")
    })
    public ResultVO findAllSales(@RequestParam(value = "currentPage",defaultValue = "1")Integer page,
                                 @RequestParam(value = "pageSize",defaultValue = "5")Integer size,
                                 @RequestParam(value = "flag",defaultValue = "0")Integer flag,
                                 @RequestHeader(value = "origin",required = false)String origin,
                                 HttpServletResponse resp){
//        currentPage=1
//        pageSize=5
//        flag=0
        PageVO pageVO = saleService.findAllSalesByPages(page, size, flag);
        if (pageVO==null){
            log.info("【销售记录】 查询销售记录失败！！！pageVO={}",pageVO);
            return R.error(JxcEnum.PARAM_ERROR);
        }
        return R.ok(pageVO);
    }
}
