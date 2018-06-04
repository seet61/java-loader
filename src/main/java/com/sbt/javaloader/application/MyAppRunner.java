package com.sbt.javaloader.application;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAppRunner {
    public static void main(String[] args) {
        MyAppClassloader myAppClassloader = new MyAppClassloader(ClassLoader.getSystemClassLoader());
        try {
            Class<?> myAppClass = myAppClassloader.findClass("com.sbt.javaloader.application.MyApp");
            Object calculatorApp = myAppClass.newInstance();
            //проверяем что вызывается метод корректно
            Method md = myAppClass.getMethod("addition");
            md.invoke(calculatorApp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
