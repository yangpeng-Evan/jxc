package com.yp.service.impl;

import com.yp.entity.User;
import com.yp.enums.JxcEnum;
import com.yp.exception.JxcException;
import com.yp.mapper.UserMapper;
import com.yp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangpeng
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByUsername(String username) {
        if (username == null){
            log.error("【登录功能】 参数错误，用户名称不能为空！！！username={}",username);
            throw new JxcException(JxcEnum.PARAM_ERROR);
        }
        User param = new User();
        param.setUsername(username);
        User user = userMapper.selectOne(param);
        if (user ==null){
            log.error("【登录功能】 根据用户名查询用户信息失败！！！username={}",username);
            throw new JxcException(JxcEnum.USERNAMEORPASSWORD_ERROR);
        }
        return user;
    }
}
