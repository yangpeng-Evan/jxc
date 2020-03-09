package com.yp.exception;

import com.yp.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PoorExceptionHandler {


    @ExceptionHandler(JxcException.class)
    public ResultVO poor(JxcException ex){
        return new ResultVO(ex.getCode(),ex.getMessage(),null);
    }


}
