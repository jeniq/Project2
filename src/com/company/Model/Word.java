package com.company.Model;

import java.util.HashMap;

/**
 * This class performs work with word.
 * It contains constructor for creating new word,
 * methods to return the word and compare them.
 *
 * @version 14 June 2016
 * @author Yevhen Hryshchenko
 */
public class Word implements Text, Comparable<Word>{
    private static HashMap<String , String > lowerCache = new HashMap<>();
    private String word;

    public Word(String word){
        this.word = word;
    }

    @Override
    public String toString(){
        return word;
    }

    @Override
    public int compareTo(Word o) {

        String firstLower = getLowerString(word);
        String secondLower = getLowerString(o.word);


        for (int i = 0; i < o.toString().length(); i++){
            if (firstLower.charAt(i) == secondLower.charAt(i)){
                if (i == this.toString().length() - 1){
                    return 1;
                }
                continue;
            }
            if (firstLower.charAt(i) < secondLower.charAt(i)){
                return -1;
            }else{
                return 1;
            }
        }
        return 0;
    }

    private static String getLowerString(String str) {
        String firstLower = lowerCache.get(str);
        if( firstLower == null ){
            lowerCache.put( str, firstLower = str.toLowerCase());
        }
        return firstLower;
    }
}
