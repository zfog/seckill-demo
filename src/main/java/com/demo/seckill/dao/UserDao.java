package com.demo.seckill.dao;

import com.demo.seckill.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    User findByName(String name);

    List<User> findAll();

    int insertUser(User name);
}
