package com.demo.seckill.service;

import com.demo.seckill.dao.UserDao;
import com.demo.seckill.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    public UserDao userDao;

    public User findById(int id){
        return userDao.findById(id);
    }

    @Transactional
    public int insertUser(User name) {
        return userDao.insertUser(name);
    }
}
