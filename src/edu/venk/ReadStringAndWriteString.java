package edu.venk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadStringAndWriteString {
    public static void main(String[] args) throws IOException {
        // writes the given string into the temp file
        Path path = Files.writeString(Files.createTempFile("Hello", ".txt"), "Welcome to java.nio.file");
        // reads the content of the file as a single string and returns it
        System.out.println(Files.readString(path));
    }
}
