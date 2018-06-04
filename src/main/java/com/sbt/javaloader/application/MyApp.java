package com.sbt.javaloader.application;

import com.sbt.javaloader.app.CalculatorApp;
import com.sbt.javaloader.impl.CalculatorImpl;

public class MyApp extends CalculatorApp {
    static CalculatorImpl calculator = new CalculatorImpl();

    public MyApp() {
    }

    @Override
    public void addition() {
        System.out.println(this.calculator.addition(5, 5));
    }

    /*public static void main(String[] args) {
        System.out.println(calculator.addition(5, 5));
        System.out.println(calculator.subtraction(5, 3));
    }*/
}
