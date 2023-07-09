package com.example.reflection.service.impl;

import com.example.reflection.service.MyClass;

/**
 * @author: lichengcan
 * @date: 2023-07-09 09:47
 * @description
 **/
public class MyClassImpl implements MyClass {
    @Override
    public void test(String name, Integer age) {
        System.out.println("我叫 ： " + name+"，今年"+age+"岁。");
    }
}
