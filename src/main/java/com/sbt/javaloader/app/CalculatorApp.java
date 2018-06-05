package com.sbt.javaloader.app;

import com.sbt.javaloader.impl.CalculatorImpl;

public class CalculatorApp {
    CalculatorImpl calculator;

    public CalculatorApp() {
        this.calculator = new CalculatorImpl();
    }

    public void addition() {
        System.out.println(this.calculator.addition(2, 2));
    }
}
