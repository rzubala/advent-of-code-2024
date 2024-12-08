package com.zubala.rafal.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utils {

    private static final String PATH = "src/main/java/com/zubala/rafal/";
    public static List<String> readAllLines(String fileName) {
        try {
            return Files.readAllLines(Paths.get(PATH + fileName));
        } catch (IOException e) {
            return List.of();
        }
    }
}
