package com.example.norepeatsubmit.controller;

import com.example.norepeatsubmit.annotation.NoRepeatSubmit;
import com.example.norepeatsubmit.annotation.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lichengcan
 * @date: 2023-06-27 21:27
 * @description 测试controller
 **/
@RestController
@RequestMapping("/api")
@ResponseResult
public class UserController {

    @PostMapping("/testNoRepeat")
    @NoRepeatSubmit
    public void testNoRepeat() {
        System.out.println("true = " + 1);
    }
}
