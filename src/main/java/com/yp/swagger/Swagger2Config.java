package com.yp.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author yangpeng
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket docket(){
        // 0. ApiInfo对象.
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("进销存管理系统接口文档")
                .contact(new Contact("杨鹏","https://www.baidu.com/s?ie=UTF-8&wd=github","13478530122@163.com"))
                .version("1.0.0")
                .build();

        // 指定swagger2在线文档, 哪个包下的controller需要生成在线文档,以及哪种映射路径需要生成在线文档.
        // 1. apis指定扫描的包.   2. paths指定请求路径的正则.
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yp.controller"))
               // .paths(regex("/**/.*"))
//                .paths()
                .build()
                .apiInfo(apiInfo);

        return docket;
    }
}
