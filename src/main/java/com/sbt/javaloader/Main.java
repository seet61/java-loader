package com.sbt.javaloader;

import com.sbt.javaloader.api.ApiClassloader;

public class Main {
    public static void main(String[] args) {
        ApiClassloader apiClassloader = new ApiClassloader();
        try {
            Class<?> icalc = apiClassloader.findClass("ICalculator");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
