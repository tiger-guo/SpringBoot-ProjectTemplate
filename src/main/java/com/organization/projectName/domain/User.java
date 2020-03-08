package com.organization.projectName.domain;

import lombok.Data;

/**
 * @program: springboot-learn-shiyanlou
 * @description:
 * @author: liuguohu
 * @create: 2020-03-07 18:28
 **/

@Data
public class User {

    public int id;

    private String username;

    private String password;
}
