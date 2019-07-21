package com.zzc.datasaleslogin.ServiceIml;

import com.zzc.datasaleslogin.Mapper.UserMapper;
import com.zzc.datasaleslogin.Model.User;
import com.zzc.datasaleslogin.Service.UserService;
import com.zzc.datasaleslogin.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceIml implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList(){
        return userMapper.getAllUser();
    }

    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    public Result regist(User user) {
        user.setUsername(user.getPhone());
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User existUser = userMapper.findUserByName(user.getUsername());
            if(existUser != null){
                //如果用户名已存在
                result.setMsg("用户名已存在");

            }else{
                userMapper.regist(user);
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    public Result login(User user) {
        Result result = new Result();
        System.out.println(user.getUsername());
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Integer userId= userMapper.login(user);
            if(userId == null){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                user.setId(userId);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
