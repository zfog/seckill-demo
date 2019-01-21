package com.demo.seckill.dao;

import com.demo.seckill.model.User;

import java.util.List;

public interface UserDao {

    User findById(long id);

    User findByName(String nickname);

    List<User> findAll();

    int insertUser(User name);
}
