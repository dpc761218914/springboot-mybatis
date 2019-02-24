package com.spring.mybatis.controller;

import com.spring.mybatis.bean.User;
import com.spring.mybatis.dao.UserDao;
import com.spring.mybatis.mapper.ConfigMapper;
import com.spring.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: yhy
 * @Date: 2018/7/25 16:09
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    ConfigMapper configMapper;

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @RequestMapping("/select/{id}")
    public User selectUser(@PathVariable("id") Integer id) {
        User user = configMapper.selectUserById(id);
        return user;
    }

    @RequestMapping("/cha/{id}")
    public String selectUserId(@PathVariable("id") Integer id) {
        User user = userService.selectUserId(id);
        if (user==null){
            return "未查询到数据";
        }
        return user.toString();
    }

    @RequestMapping("/findAll")
    public String selectUsers() {
        List<User> users = userService.selectUsers();
        if (users==null){
            return "未查询到数据";
        }
        return users.toString();
    }

    //用户插入数据
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public String insertUser(@RequestParam("id") int id,
                             @RequestParam("username") String username) {
        User user=new User();
        user.setUsername(username);
        user.setId(id);
        int status = userService.insertUser(user);
        return "插入成功";
    }
    /*@RequestMapping("/update")
    public User updateUserId() {
        User user = new User();
        user.setId(15);
        user.setUsername("zhangsan");
        User user1 = userService.updateUserId(user);
        return user1;
    }*/

    public static void main(String[] args) {
        ConcurrentMapCache mapCache = new ConcurrentMapCache("redis");
        mapCache.put("yang","hao");
        System.out.println(mapCache.getName());
    }

}
