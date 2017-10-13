package com.octave.service.user.impl;

import com.octave.mapper.UserMapper;
import com.octave.entity.User;
import com.octave.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Paosin Von Scarlet on 2017/10/11.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
//@Transactional(propagation = Propagation.REQUIRED)
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public Boolean save(User user) {
        try {
            this.userMapper.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean removeById(Integer id) {
        try {
            this.userMapper.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(User user) {
        try {
            this.userMapper.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<User> listAll() {
        return this.userMapper.listAll();
    }

    @Override
    public User getById(Integer id) {
        return this.userMapper.getById(id);
    }

    @Override
    public User checkLogin(String userName, String password) {
        User user;
        try {
            user = this.userMapper.checkLogin(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public User getByTel(String tel) {
        return this.userMapper.getByTel(tel);
    }

}
