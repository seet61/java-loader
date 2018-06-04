package com.sbt.javaloader;

import com.sbt.javaloader.api.ApiClassloader;
import com.sbt.javaloader.api.ICalculator;
import com.sbt.javaloader.app.AppClassloader;
import com.sbt.javaloader.app.CalculatorApp;
import com.sbt.javaloader.impl.CalculatorImpl;
import com.sbt.javaloader.impl.ImplClassloader;

public class Main {
    public static void main(String[] args) {
        ApiClassloader apiClassloader = new ApiClassloader(ClassLoader.getSystemClassLoader());
        ImplClassloader implClassloader = new ImplClassloader(ApiClassloader.getSystemClassLoader());
        AppClassloader appClassloader = new AppClassloader(ApiClassloader.getSystemClassLoader());
        try {
            //загрузка интефейса
            Class<?> icalc = apiClassloader.findClass("com.sbt.javaloader.api.ICalculator");
            //ICalculator iCalculator = (ICalculator) icalc.newInstance();

            //загрузка имплементации
            Class<?> calcImpl = implClassloader.findClass("com.sbt.javaloader.impl.CalculatorImpl");
            CalculatorImpl calculatorImpl = (CalculatorImpl) calcImpl.newInstance();

            //загрузка приложения
            Class<?> calcApp = appClassloader.findClass("com.sbt.javaloader.app.CalculatorApp");
            CalculatorApp calculatorApp = (CalculatorApp) calcApp.newInstance();
            //проверяем что вызывается метод корректно
            calculatorApp.addition();

            //из AppClassloader недоступна загрузка CalculatorImpl
            Class<?> calcApp1 = appClassloader.findClass("com.sbt.javaloader.impl.CalculatorImpl");
            CalculatorImpl calculatorImpl1 = (CalculatorImpl) calcApp1.newInstance();
            System.out.println(calculatorImpl1.addition(1, 2));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
