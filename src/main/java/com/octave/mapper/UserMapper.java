package com.octave.mapper;

import com.octave.entity.User;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Paosin Von Scarlet on 2017/10/12.
 */
@Component("userMapper")
public interface UserMapper {
    List<User> listAll();

    User getById(Integer uid);

    void update(User user);

    void save(User user);

    void remove(Integer id);

    void removeAll(Integer[] ids);

    User checkLogin(String userName, String password);

    User getByTel(String tel);
}
