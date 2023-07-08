package com.example.reflection.handler;

import com.example.reflection.obj.MyClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class MyInvocationHandler implements InvocationHandler {

    private MyClass myClass;
    public MyInvocationHandler(MyClass myClass){
        this.myClass=myClass;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在代理对象上调用方法前的操作
        Object result = method.invoke(myClass, args);
        // 在代理对象上调用方法后的操作
        return result;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new MyClass());
        Class<?> aClass = Class.forName("com.example.reflection.obj.MyClass");
        MyClass instance = (MyClass) Proxy.newProxyInstance(aClass.getClassLoader(), new Class[]{aClass}, myInvocationHandler);
    }
}