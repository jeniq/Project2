package com.company.Model;

/**
 *  This class implements work work sentence.
 *  It contains constructor for creating new
 *  sentence.
 *
 *  @version 16 June 2016
 *  @author Yevhen Hryshchenko
 */
public class Sentence implements Text {
    String sentence;

    public Sentence(String sentence){
        this.sentence = sentence;
    }

    @Override
    public String toString(){
        return sentence;
    }
}
