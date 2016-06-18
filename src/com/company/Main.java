package com.company;

import com.company.Controller.Controller;
import com.company.Model.AlphabetWord;
import com.company.View.View;

public class Main {

    public static void main(String[] args) {
        // Initialization
        AlphabetWord alphabetWord = new AlphabetWord("");
        View view = new View();
        Controller controller = new Controller(alphabetWord, view, Constants.PATH);

        // Run
        controller.processUser();
    }
}
