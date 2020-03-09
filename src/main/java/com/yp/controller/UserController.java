package com.yp.controller;

import com.yp.entity.User;
import com.yp.enums.JxcEnum;
import com.yp.util.R;
import com.yp.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangpeng
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户模块")
@Slf4j
@CrossOrigin(allowCredentials = "true")
public class UserController {

    @PostMapping("/register")
    @ApiOperation(value = "注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名称"),
            @ApiImplicitParam(name = "password",value = "用户密码")
    })
    public ResultVO register(String username,String password){
        return R.ok();
    }


    @ApiOperation(value = "登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名"),
            @ApiImplicitParam(name = "password",value = "密码")
    })
    @PostMapping("/login")
    public ResultVO login(String username,String password){
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            log.info("【登录功能】 用户名和密码是必填项，不能为空！！！");
            return R.error(JxcEnum.PARAM_ERROR.getCode(),"用户名和密码不能为空");
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            log.info("【登录功能】 用户名或密码错误  username={},password={}",username,password);
            return R.error(JxcEnum.PARAM_ERROR.getCode(),"用户名或密码错误！");
        }
        return R.ok();
    }

    @GetMapping("/info")
    @ApiOperation(value = "获取登录用户的真实姓名接口")
    public ResultVO getName(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user==null){
            log.info("【登录功能】 获取用户姓名失败！！！user={}",user);
            return R.error(JxcEnum.USER_NOT_LOGIN);
        }
        return R.ok(user.getRealname());
    }

    @PostMapping("/logout")
    @ApiOperation(value = "退出登录接口")
    public ResultVO logout(){
        //获取subject主体
        Subject subject = SecurityUtils.getSubject();
        //执行退出登录功能
        subject.logout();
        //相应数据
        return R.ok();
    }
}
