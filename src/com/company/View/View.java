package com.company.View;

/**
 * This class consists string constants and
 * method to print text to console.
 *
 * @version 16 June 2016
 * @author Yevhen Hryshchenko
 */
public class View {
    // Constants
    public static final String TOKENS = "[,.:;!?]";
    public static final String SPLIT_SENTENCE = "[!?.] ";
    public static final String DOT = ".";
    public static final String FILE_NOT_FOUND = "File not found: ";

    public void printText(String message){
        System.out.println(message);
    }
}
