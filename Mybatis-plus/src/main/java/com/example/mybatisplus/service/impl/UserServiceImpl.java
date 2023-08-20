package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.entity.UserDO;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lichengcan
 * @date: 2023-08-20 16:16
 * @description
 **/
@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper,UserDO>  implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDO getById(Long id) {
        return userMapper.selectById(id);
    }
}
