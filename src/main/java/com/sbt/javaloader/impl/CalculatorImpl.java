package com.sbt.javaloader.impl;

import com.sbt.javaloader.api.ICalculator;

public class CalculatorImpl implements ICalculator {
    public CalculatorImpl() {
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }
}
