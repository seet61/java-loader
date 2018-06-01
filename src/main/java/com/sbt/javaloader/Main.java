package com.sbt.javaloader;

import com.sbt.javaloader.api.ApiClassloader;

public class Main {
    public static void main(String[] args) {
        ApiClassloader apiClassloader = new ApiClassloader(ClassLoader.getSystemClassLoader(), "target\\classes");
        try {
            Class<?> icalc = apiClassloader.findClass("com.sbt.javaloader.api.ICalculator");
            System.out.println("Loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
