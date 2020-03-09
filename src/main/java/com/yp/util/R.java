package com.yp.util;

import com.yp.enums.JxcEnum;
import com.yp.exception.JxcException;
import com.yp.vo.ResultVO;

/**
 * @author yangpeng
 */
public class R {

    public static ResultVO ok(Object data){
        ResultVO vo = new ResultVO(0,"成功",data);
        return vo;
    }

    public static ResultVO ok(){
        return ok(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO vo = new ResultVO(code,msg,null);
        return vo;
    }

    public static ResultVO error(JxcException ex){
        ResultVO vo = new ResultVO(ex.getCode(),ex.getMessage(),null);
        return vo;
    }

    public static ResultVO error(JxcEnum jxcEnum){
        ResultVO vo = new ResultVO(jxcEnum.getCode(),jxcEnum.getMsg(),null);
        return vo;
    }

}
