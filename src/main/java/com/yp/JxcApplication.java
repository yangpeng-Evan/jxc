package com.yp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yangpeng
 */
@SpringBootApplication
@MapperScan("com.yp.Mapper")
public class JxcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JxcApplication.class, args);
    }

}
