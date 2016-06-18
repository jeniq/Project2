package com.company.Controller;

import java.io.FileReader;
import java.io.IOException;

/**
 * This class implements work with file.
 * It consists method to read data from file.
 *
 * @version 14 June 2016
 * @author Yevhen Hryshchenko
 */
public class FileOperations {
    /**
     * This method reads data from file.
     * @param path path to file
     * @return string of data
     * @throws IOException
     */
    public String readFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        StringBuilder buffer = new StringBuilder();

        int symbol = 0;

        symbol = fr.read();
        while (symbol != -1) {
            symbol = fr.read();
            buffer.append((char) symbol);
        }
        fr.close();
        return buffer.toString();
    }
}
