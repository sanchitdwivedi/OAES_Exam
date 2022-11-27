package com.example.oaes_exam.dao;

import com.example.oaes_exam.entity.User;

public interface UserDao {
    public User findByUserId(long userId) throws Exception;
    public void save(User user) throws Exception;
}
