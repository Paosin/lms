package com.octave.mapper;

import com.octave.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Paosin Von Scarlet on 2017/10/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Test
    public void checkLogin() throws Exception {
        System.out.println(userMapper.checkLogin("123", "123"));
    }


    @Autowired
    private UserMapper userMapper;

    @Test
    public void listAll() throws Exception {
        for (User user : userMapper.listAll()) {
            System.out.println(user);
        }
    }

    @Test
    public void getOne() throws Exception {
        System.out.println(userMapper.getById(1));
    }

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setUserName("123");
        user.setPassword("123");
        user.setType(2);
        userMapper.save(user);
    }
}
