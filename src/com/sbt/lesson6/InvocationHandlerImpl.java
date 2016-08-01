package com.sbt.lesson6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 28.07.2016.
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private final Object delegate;

    public InvocationHandlerImpl(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Start " + method.getName());
        Object result = method.invoke(delegate, args);
        System.out.println("End method " + method.getName() + "result: " + result);
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> loggedList = (List<String>)Proxy.newProxyInstance(list.getClass().getClassLoader(),
                list.getClass().getInterfaces(),
                new InvocationHandlerImpl(list));

        loggedList.add("first");
        System.out.println(loggedList.get(0));
        loggedList.remove(0);
    }
}
