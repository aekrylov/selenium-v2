package com.github.aekrylov.itis.sem05.selenium.misc;

import java.io.*;
import java.util.Properties;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 12/10/17 7:26 PM
 */
public class PropertiesReader {

    public static Properties read(File file) throws FileNotFoundException {
        return read(new FileInputStream(file));
    }

    public static Properties read(InputStream is) {
        Properties properties = new Properties();
        try {
            properties.load(is);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Could not read properties file", e);
        }
    }

    public static Properties read(String absolutePath) {
        return read(PropertiesReader.class.getResourceAsStream("/" + absolutePath));
    }
}
