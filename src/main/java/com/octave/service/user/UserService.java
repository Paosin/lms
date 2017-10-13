package com.octave.service.user;

import com.octave.entity.User;

import java.util.List;

/**
 * Created by Paosin Von Scarlet on 2017/10/11.
 */
public interface UserService{
    Boolean save(User user);

    Boolean removeById(Integer id);

    Boolean update(User user);

    List<User> listAll();

    User getById(Integer id);

    User checkLogin(String userName, String password);

    User getByTel(String tel);
}
