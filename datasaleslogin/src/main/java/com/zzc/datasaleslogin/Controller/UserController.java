package com.zzc.datasaleslogin.Controller;

import com.zzc.datasaleslogin.Model.User;
import com.zzc.datasaleslogin.Service.UserService;
import com.zzc.datasaleslogin.Util.CreateToken;
import com.zzc.datasaleslogin.Util.MyRedis;
import com.zzc.datasaleslogin.Util.Result;
import com.zzc.datasaleslogin.Util.SendMessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Resource
    UserService userService;

    @Resource
    MyRedis redis; //redis类

    @GetMapping(value = "/list")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    /**
     * 注册
     */
    @PostMapping(value = "/regist")
    public Result regist(@RequestBody User user){
        if(user.getMeaasgeCode().equals(redis.get("sms_"+user.getPhone()))) {
            return userService.regist(user);
        }
        Result result = new Result();
        result.setMsg("验证码失效或有误！");
        return result;
    }
    /**
     * 登录
     */
    @PostMapping(value = "/login")
    public Result login(@RequestBody User user){
        Result<User> result = userService.login(user);
        result.setToken(CreateToken.getToken(result.getDetail()));
        redis.set("Token:",CreateToken.getToken(result.getDetail()),1800);  //设置Token缓存1800s(30分钟)
        return result;
    }

    /**
     * 短线发送 获取验证码
     */
    @PostMapping(value = "/sendCode")
    @ResponseBody
    public String sendCode(@RequestBody User user){
        String messageCode = SendMessageUtil.getRandomCode(6);
        int code = SendMessageUtil.send("zzcz","d41d8cd98f00b204e980",user.getPhone(),"您的验证码:"+messageCode);
        redis.set("sms_"+user.getPhone(),messageCode,60);  //  验证码存入redis缓存 设置时间失效时间为60s
        return SendMessageUtil.getMessage(code);
    }
}
