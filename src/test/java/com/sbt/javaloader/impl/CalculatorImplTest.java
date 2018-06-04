package com.sbt.javaloader.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorImplTest {
    @Parameterized.Parameter
    public int a;

    @Parameterized.Parameter(1)
    public int b;

    @Parameterized.Parameter(2)
    public int expected;

    private CalculatorImpl calculator = new CalculatorImpl();

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{{5, 2, 7}, {1, 1, 2}, {2, 1, 3}});
    }

    @Test
    public void addition() {
        assertEquals("Test int addition", expected, calculator.addition(a, b));
    }

    @Test(expected = AssertionError.class)
    public void subtraction() {
        assertEquals("Test int subtraction", expected, calculator.subtraction(a, b));
    }
}
