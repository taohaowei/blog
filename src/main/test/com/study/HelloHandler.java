package com.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 14978 on 2017/8/15.
 */
public class HelloHandler implements InvocationHandler {
    private Object delegate;


    public Object bind(Object delegate)
    {
        this.delegate = delegate;
        System.out.println("this.delegate.getClass() = "+this.delegate.getClass());
        System.out.println("this.delegate.getClass().getInterfaces() = "+this.delegate.getClass().getInterfaces());
        System.out.println("this = "+this);
        return Proxy.newProxyInstance(
                this.delegate.getClass().getClassLoader(), this.delegate
                        .getClass().getInterfaces(), this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            //执行原来的方法之前记录日志
            Logger.logger(Level.EORR, method.getName() + " 方法开始.");

            //JVM通过这条语句执行原来的方法(反射机制)
            result = method.invoke(this.delegate, args);
            //执行原来的方法之后记录日志
            Logger.logger(Level.INFO, method.getName() + " 方法结束.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("result = "+result);
        //返回方法返回值给调用者
        return result;
    }
}
