package com.yp.service;

import com.yp.JxcApplicationTests;
import com.yp.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceTest extends JxcApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    public void findUserByUsername() {
        User zhangsan = userService.findUserByUsername("zhangsan");
        System.out.println(zhangsan);
        assertNotNull(zhangsan);
    }
}