package com.he.jwtlearn.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2022-6-20 10:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    String id;

    String name;

    String password;
}
