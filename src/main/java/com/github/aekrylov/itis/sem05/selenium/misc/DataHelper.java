package com.github.aekrylov.itis.sem05.selenium.misc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 12/10/17 7:26 PM
 */
public class DataHelper {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

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
        return read(DataHelper.class.getResourceAsStream("/" + absolutePath));
    }

    public static <T> T readJson(String absolutePath, Class<T> c) {
        Reader reader = new InputStreamReader(DataHelper.class.getResourceAsStream("/" + absolutePath));
        return gson.fromJson(reader, c);
    }

    public static void writeJson(Path file, Object data) throws IOException {
        String json = gson.toJson(data);
        Files.write(file, json.getBytes());
    }
}
