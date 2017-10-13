package com.octave.service.user.impl;

import com.octave.entity.User;
import com.octave.service.user.UserService;
import com.octave.util.regex.CheckRegEx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Paosin Von Scarlet on 2017/10/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void save() throws Exception {
        User user = new User();

        user.setUserName("123456");
        user.setPassword("123456");
        user.setEmail("123456@qq.com");
        user.setTel("15608185191");
        System.out.println("check result-------------"+CheckRegEx.check(user));
    }

}