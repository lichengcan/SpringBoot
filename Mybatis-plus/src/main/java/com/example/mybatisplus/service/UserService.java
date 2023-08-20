package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.entity.UserDO;

/**
 * @author lichengcan
 */
public interface UserService extends IService<UserDO> {
    UserDO getById(Long id);
}
