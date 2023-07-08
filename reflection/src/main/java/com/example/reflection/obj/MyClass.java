package com.example.reflection.obj;

import lombok.Data;

/**
 * @author: lichengcan
 * @date: 2023-07-07 09:52
 * @description
 **/
public class MyClass {

    private String job = "cxy";

    public void test(String name,Integer age){
        System.out.println("我叫 ： " + name+"，今年"+age+"岁。");
    }
}
