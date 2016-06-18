package com.company.Controller;

import com.company.Model.AlphabetWord;
import com.company.Model.Sentence;
import com.company.Model.Word;
import com.company.View.View;

import java.io.IOException;
import java.util.List;

/**
 * This class performs operations with data.
 * It reads data from file and then use parser to divide text.
 * It consists methods to sort words, fill list of words by alphabet
 * and print sentences of text.
 *
 * @version 16 June 2016
 * @author Yevhen Hryshchenko
 */
public class Controller {
    private AlphabetWord alphabetWord;
    private Parser parser;
    private View view;
    private String path;
    private WordFactory wordFactory;
    private FileOperations fileOperations;

    // Constructor
    public Controller(AlphabetWord alphabetWord, View view, String path){
        this.alphabetWord = alphabetWord;
        this.view = view;
        this.path = path;
        wordFactory = new WordFactory();
        parser = new Parser(wordFactory);
        fileOperations = new FileOperations();
    }

    // The work method
    public void processUser(){
        try {
            List<Sentence> sentences = parser.parseTextBySentence(fileOperations.readFile(path));
            List<Word> workList = parser.parseTextByWords(sentences);
            printSentences(sentences);
            sortWords(workList);
            fillByAlphabet(workList);
            view.printText(alphabetWord.toString());
        } catch (IOException e) {
            view.printText(View.FILE_NOT_FOUND + path);
        }
    }

    // Insertion sort
    private void sortWords(List<Word> words){
        Word temp;
        int i;
        for (int j = 1; j < words.size(); j++){
            temp = words.get(j);
            i = j - 1;
            while ((i >= 0)
                && (words.get(i).compareTo(temp) > 0)){
                words.set(i+1, words.get(i));
                i--;
            }
            words.set(i + 1, temp);
        }
    }

    /**
     * This method groups words by alphabet.
     * @param words input words
     */
    private void fillByAlphabet(List<Word> words){
        AlphabetWord letter;
        letter = new AlphabetWord(Character.toString(words.get(0).toString().toLowerCase().charAt(0)));
        for (int i = 1; i < words.size(); i++){
            if (!letter.getName().equals(Character.toString(words.get(i).toString().toLowerCase().charAt(0)))){
                alphabetWord.addWord(letter);
                letter = new AlphabetWord(Character.toString(words.get(i).toString().charAt(0)));
            }
            if (!letter.getWords().contains(words.get(i))){
                letter.addWord(words.get(i));
            }
        }
        alphabetWord.addWord(letter);
    }

    /**
     * This method prints sentences to console.
     * @param sentences list of sentences
     */
    private void printSentences(List<Sentence> sentences){
        StringBuffer buffer = new StringBuffer();
        for (Sentence s : sentences){
            buffer.append(s);
        }
        view.printText(buffer.toString());
    }
}
