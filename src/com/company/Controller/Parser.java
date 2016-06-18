package com.company.Controller;

import com.company.Constants;
import com.company.Model.Sentence;
import com.company.Model.Word;
import com.company.View.View;

import java.util.ArrayList;
import java.util.List;

/**
 * This class parses input text.
 * This class uses flyweight pattern.
 * It consists methods for parsing by sentence and by word.
 *
 * @version 16 June 2016
 * @author Yevhen Hryshchenko
 */
public class Parser {
    private WordFactory wordFactory;
    private StringBuffer buffer;
    private boolean isCode;

    public Parser(WordFactory wordFactory){
        this.wordFactory = wordFactory;
    }

    /**
     * This method parses input text by sentence.
     * @param text input string
     * @return list of sentences
     */
    public List<Sentence> parseTextBySentence(String text){
        List<Sentence> sentences = new ArrayList<>();
        buffer = new StringBuffer();
        isCode = false;
        char temp = ' ';

        for (String s : text.split(View.SPLIT_SENTENCE)){
            for (Character ch : s.toCharArray()){
                if (!(temp == ' ' && ch == ' ')){
                    if(checkForCodeMark(ch)){
                        isCode = switchValue(isCode);
                    }
                    buffer.append(ch);
                }
                temp = ch;
            }
            if (!isCode && buffer.length() > 1){
                sentences.add(new Sentence(buffer.toString()+ View.DOT));
                buffer = new StringBuffer();
            }
        }
        return sentences;
    }

    /**
     * This method parses sentence by word
     * @param sentences input sentences
     * @return list of words
     */
    public List<Word> parseTextByWords(List<Sentence> sentences){
        buffer = new StringBuffer();
        List<Word> words = new ArrayList<>();
        boolean isCode = false;

        for (Sentence s : sentences) {
            for (Character ch : s.toString().toCharArray()) {
                if (checkForCodeMark(ch)) {
                    isCode = switchValue(isCode);
                    continue;
                }
                if (!isCode) {
                    if (Character.isWhitespace(ch) || ch.toString().matches(View.TOKENS)) {
                        if (buffer.length() >= Constants.WORD_SIZE) {
                            words.add(wordFactory.getWord(buffer.toString()));
                        }
                        buffer = new StringBuffer();
                    } else {
                        buffer.append((char) ch);
                    }
                }
            }
        }
        return words;
    }

    /**
     * This method checks character is code started
     * @param ch input character
     * @return boolean
     */
    private boolean checkForCodeMark(char ch){
        if (ch == Constants.CODE_MARK){
            return true;
        }
        return false;
    }

    /**
     * This method switches boolean value to opposite
     * @param value input boolean
     * @return opposite value
     */
    private boolean switchValue(boolean value){
        return value ? false : true;
    }
}
