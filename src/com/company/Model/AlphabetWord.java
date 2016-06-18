package com.company.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class collects words by alphabet in
 * different composites.
 * It contains methods to get name of composite,
 * add word, get list of words by letter.
 * It implements composite pattern.
 *
 * @version 14 June 2016
 * @author Yevhen Hryshchenko
 */
public class AlphabetWord implements Text{
    private List<Text> words = new ArrayList<>();
    private String name;

    public AlphabetWord(String name){
        this.name = name;
    }

    public void addWord(Text word){
        words.add(word);
    }

    public String getName(){
        return name;
    }

    public List<Text> getWords(){
        return words;
    }

    @Override
    public String toString(){
        return "\n" + name + "\n" + words.toString() ;
    }
}
