package com.spring.mybatis.mapper;

import com.spring.mybatis.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: yhy
 * @Date: 2018/7/25 16:07
 * @Version 1.0
 * 这个使用的注解的方式@Mapper 和用注解的sql语句   也可以在启动类上使用这种方式@MapperScan(value = "com.spring.mybatis.mapper")
 */
@Mapper
public interface ConfigMapper {

    @Select("select * from user where id = #{id}")
    public User selectUserById(Integer id);
    @Select("select * from user")
    public List<User> selectUsers();
    @Insert("insert into user  values(#{id},#{username})")
    public String insertUser(User user);


}
