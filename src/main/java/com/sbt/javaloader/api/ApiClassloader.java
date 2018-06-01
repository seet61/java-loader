package com.sbt.javaloader.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiClassloader extends ClassLoader{
    //путь для загрузки
    private String pathToBin = "C:\\Projects\\java-loader\\target\\classes\\com\\sbt\\javaloader\\api";

    public ApiClassloader() {
    }

    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            /**
             * Получем байт-код из файла и загружаем класс в рантайм
             */
            File f = new File(pathToBin, className + ".class");
            System.out.println(f.toString());
            byte b[] = loadClassData(f.toString());
            return defineClass(className, b, 0, b.length);
        } catch (FileNotFoundException ex) {
            return super.findClass(className);
        } catch (IOException ex) {
            return super.findClass(className);
        }
    }

    /*
    //http://www.ilnurgi1.ru/docs/java/java/lang/ClassLoader.html
    private byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(new File(path));

        // Get the size of the file
        long length = new File(path).length();

        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+path);
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;

    }
    */

    private byte[] loadClassData(String name) throws FileNotFoundException, IOException {
        // load the class data from the connection
        Path path = Paths.get(name);
        byte[] data = Files.readAllBytes(path);
        return data;
    }
}
