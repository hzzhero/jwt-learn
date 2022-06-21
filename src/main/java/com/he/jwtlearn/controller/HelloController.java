package com.he.jwtlearn.controller;

import com.he.jwtlearn.bean.User;
import com.he.jwtlearn.utils.JwtUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2022-6-20 10:16
 */
@RestController
public class HelloController {


    @GetMapping("/getToken")
    public String getToken(String name,String pass){
        return JwtUtils.getJwtToken(new User("1",name,pass));
    }

    @PostMapping("/parseToken")
    public Object parseToken(@RequestBody String token){
        return JwtUtils.decode(token);
    }
}
