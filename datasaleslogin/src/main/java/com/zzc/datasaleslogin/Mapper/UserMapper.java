package com.zzc.datasaleslogin.Mapper;

import com.zzc.datasaleslogin.Model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询所以用户
     * @return List<User>
     */
    @Select("select * from user")
    List<User> getAllUser();

    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value) 若value与可变参数相同，注解可省略
     * 注解@Results  列名和字段名相同，注解可省略
     * @param username
     * @return
     */
    @Select(value = "select u.username,u.password from user u where u.username=#{username}")
    @Results
            ({@Result(property = "username",column = "username"),@Result(property = "password",column = "password")})
    User findUserByName(@Param("username") String username);
    /**
     * 注册 插入一条user记录
     * @param user
     * @return
     */
    @Insert("insert into user(username,password) values(#{username},#{password})")
    void regist(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    @Select("select u.id from user u where u.username = #{username} and password = #{password}")
    Integer login(User user);
}