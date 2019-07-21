package com.zzc.datasaleslogin.Controller;

import com.zzc.datasaleslogin.Model.User;
import com.zzc.datasaleslogin.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 登录
     */
    @PostMapping(value = "/auth/login")
    public String login(@RequestBody User user) throws AuthenticationException {
        // 登录成功会返回Token给用户
        return authService.login( user.getUsername(), user.getPassword() );
    }

    @PostMapping(value = "/user/hi")
    public String userHi( String name ) throws AuthenticationException {
        return "hi " + name + " , you have 'user' role";
    }

    @PostMapping(value = "/admin/hi")
    public String adminHi( String name ) throws AuthenticationException {
        return "hi " + name + " , you have 'admin' role";
    }


}
