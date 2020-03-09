package com.yp.exception;

import com.yp.enums.JxcEnum;
import lombok.Getter;

@Getter
public class JxcException extends RuntimeException {

    private Integer code;

    public JxcException(JxcEnum poorEnum) {
        super(poorEnum.getMsg());
        this.code = poorEnum.getCode();
    }
}
