package com.example.mybatisplus.controller;

import com.example.mybatisplus.entity.UserDO;
import com.example.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lichengcan
 * @date: 2023-08-20 16:28
 * @description
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getById")
    public UserDO getById(@RequestParam Long id) {
        UserDO userDO = userService.getById(id);
        return userDO;
    }
}
