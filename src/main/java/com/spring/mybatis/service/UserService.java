package com.spring.mybatis.service;

import com.spring.mybatis.bean.User;

import java.util.List;


/**
 * @Author: yhy
 * @Date: 2018/7/25 16:34
 * @Version 1.0
 */
public interface UserService {
    //根据id查询
    public User selectUserId(Integer id);
    //查询所有数据
    public List<User> selectUsers();
    //插入数据
    public int insertUser(User user);

    /*public User updateUserId(User user);*/
}
