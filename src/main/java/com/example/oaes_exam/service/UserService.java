package com.example.oaes_exam.service;

import com.example.oaes_exam.dao.UserDao;
import com.example.oaes_exam.dao.UserDaoImpl;
import com.example.oaes_exam.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    public UserService(){
        userDao = new UserDaoImpl();
    }

    public void updateUser(User user) throws Exception {
        userDao.save(user);
    }

    public User getUserById(long userId) throws Exception {
        return userDao.findByUserId(userId);
    }
}