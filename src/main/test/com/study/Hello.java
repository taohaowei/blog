package com.study;

/**
 * Created by 14978 on 2017/8/15.
 */
public class Hello implements IHello{
    @Override
    public void sayHello(String name) {
        System.out.println("hello "+name);
    }

    @Override
    public void sayGoogBye(String name) {
        System.out.println(name+" GoodBye");
    }
}
