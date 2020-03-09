package com.yp.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel(value = "销售记录接收的表单项.")
public class SaleForm {

    @NotNull(message = "商品价格为必填项,岂能不填!")
    @ApiModelProperty(value = "商品单价.",example = "1")
    private BigDecimal price;

    @NotNull(message = "商品数量为必填项,岂能不填!")
    @ApiModelProperty(value = "商品购买数量.",example = "1")
    private Integer quantity;

    @NotNull(message = "商品为必选项,岂能不选!")
    @ApiModelProperty(value = "商品的id.",example = "1")
    private Integer productId;

}
