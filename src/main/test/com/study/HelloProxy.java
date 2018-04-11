package com.study;

/**
 * Created by 14978 on 2017/8/15.
 */
public class HelloProxy implements IHello{
    private IHello hello;

    public HelloProxy(IHello hello) {
        this.hello = hello;
    }


    @Override
    public void sayHello(String name) {
         Logger.logger(Level.EORR,"sayHello开始了！");
         hello.sayHello(name);
         Logger.logger(Level.INFO,"sayHello结束了！");
    }

    @Override
    public void sayGoogBye(String name) {
        Logger.logger(Level.EORR,"sayGoogBye开始了！");
        hello.sayGoogBye(name);
        Logger.logger(Level.INFO,"sayGoogBye结束了！");
    }
}
