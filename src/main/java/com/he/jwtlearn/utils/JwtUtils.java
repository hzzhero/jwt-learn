package com.he.jwtlearn.utils;

import com.he.jwtlearn.bean.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2022-6-20 10:00
 */
public class JwtUtils {
    // token时效：24小时
    public static final long EXPIRE = 1000 * 60 * 60 * 24;
    // 签名哈希的密钥，对于不同的加密算法来说含义不同
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHOsdadasdasfdssfeweee";

    /**
     * 根据用户id和昵称生成token
     * @param user  用户
     * @return JWT规则生成的token
     */
    public static String getJwtToken(User user){
        String JwtToken = Jwts.builder()
                //header
                .setHeaderParam("type","JWT")
                .setHeaderParam("alg", "HS256")
                //paload
                .setSubject(user.getName())//一般放用户名
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setId(UUID.randomUUID().toString())
                // signature
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken token字符串
     * @return 如果token有效返回true，否则返回false
     */
    public static Jws<Claims> decode(String jwtToken) {
        // 传入Key对象
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        return claimsJws;
    }
}

