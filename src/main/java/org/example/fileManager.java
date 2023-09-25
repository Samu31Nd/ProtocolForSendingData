package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class fileManager {
    String dataText;

    public void getText() {
        String file = "output.txt";
        this.dataText = fileManager.readTextFromFile(file, ".");
    }

    public static String readTextFromFile(String file, String path) {
        try {
            StringBuilder text = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(path + "/" + file));

            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }

            reader.close();
            return text.toString();
        } catch (IOException err) {
            System.out.println(err.getMessage());
            System.exit(2);
        }
        return " ";
    }
}