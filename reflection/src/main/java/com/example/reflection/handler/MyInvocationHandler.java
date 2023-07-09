package com.example.reflection.handler;

import com.example.reflection.service.MyClass;
import com.example.reflection.service.impl.MyClassImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class MyInvocationHandler implements InvocationHandler {

    private MyClass myClass;

    public MyInvocationHandler(MyClass myClass) {
        this.myClass = myClass;
    }

    public MyInvocationHandler() {

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        // 在代理对象上调用方法前的操作
        System.out.println("在代理对象上调用方法前的操作========");
        Object result = method.invoke(myClass, args);
        System.out.println("在代理对象上调用方法前的操作========");
        // 在代理对象上调用方法后的操作
        return result;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //实际被代理的对象
         MyClass myClass1 = new MyClassImpl();
        //拦截器
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(myClass1);
        //获取类信息
        Class<?> aClass = Class.forName("com.example.reflection.service.MyClass");
        //进行动态代理 获取类的实例(类加载器，实际被代理的类对象，拦截器)
        MyClass instance = (MyClass) Proxy.newProxyInstance(aClass.getClassLoader(), new Class[]{aClass}, myInvocationHandler);
        instance.test("海王唐智科", 38);
    }
}