package com.zzc.datasaleslogin.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zzc.datasaleslogin.Model.User;
public class CreateToken {

    /**
     * 生成 Token
     * @param user
     * @return
     */
    public static String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
