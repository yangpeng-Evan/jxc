package com.yp.vo;

import com.yp.enums.JxcEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultVO {

    private Integer code;

    private String msg;

    private Object data;

    public ResultVO(){}

    public ResultVO(JxcEnum poorEnum){
        this.code = poorEnum.getCode();
        this.msg = poorEnum.getMsg();
    }

}
