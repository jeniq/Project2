package com.company.Controller;

import com.company.Model.Word;

import java.util.HashMap;
import java.util.Map;

/**
 * This class consists method to produce new objects
 * and prevents creating same objects.
 * It implements flyweight pattern.
 *
 * @version 14 June 2016
 * @author Yevhen Hryshchenko
 */
public class WordFactory {
    private static final Map<String, Word> words = new HashMap<>();

    /**
     * This method filters creating same objects.
     * @param wordName
     * @return link to word
     */
    public Word getWord(String wordName){
        Word word = words.get(wordName);
        if (word == null){
            word = new Word(wordName);
            words.put(wordName, word);
        }
        return word;
    }
}
