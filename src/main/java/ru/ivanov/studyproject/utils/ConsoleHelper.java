package ru.ivanov.studyproject.utils;

//TODO:methods for input name and other types with validation


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    public static int readInt() {
        //add from, to for validate value
        return Integer.parseInt(readString());
    }

    public static int readInt(int from, int to) {
        return 0;
    }
}
