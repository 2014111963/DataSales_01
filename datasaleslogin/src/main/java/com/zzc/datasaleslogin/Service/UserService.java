package com.zzc.datasaleslogin.Service;

import com.zzc.datasaleslogin.Mapper.UserMapper;
import com.zzc.datasaleslogin.Model.User;
import com.zzc.datasaleslogin.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public Result regist(User user);

    public Result login(User user);

    public Result resetPassword(User user);

    public Result updatePassword(User user);
}
