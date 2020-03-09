package com.yp.service;

import com.yp.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangpeng
 */
public interface UserService {
    /**
     * 根据用户名查询用户信息
     */
    User findUserByUsername(String username);
}
