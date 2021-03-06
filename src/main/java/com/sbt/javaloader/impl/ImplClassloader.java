package com.sbt.javaloader.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImplClassloader extends ClassLoader{
    //путь для загрузки
    private String pathToBin = "target" + File.separator + "classes";

    public ImplClassloader(ClassLoader parent) {
        super(parent);
    }

    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            /**
             * Получем байт-код из файла и загружаем класс в рантайм
             */
            ///https://www.concretepage.com/java/custom-classloader-java-example
            File f = new File(pathToBin, className.replace(".", File.separator) + ".class");
            System.out.println(f.toString());
            byte b[] = loadClassData(f.toString());
            return defineClass(className, b, 0, b.length);
        } catch (FileNotFoundException ex) {
            return super.findClass(className);
        } catch (IOException ex) {
            return super.findClass(className);
        }
    }

    private byte[] loadClassData(String name) throws IOException {
        // load the class data from the connection
        Path path = Paths.get(name);
        return Files.readAllBytes(path);

    }
}
