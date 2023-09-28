package org.example;

import java.io.*;
import java.util.Map;

public class fileManager {
    BufferedWriter binaryFile;
    {
        try{
            binaryFile = new BufferedWriter(new FileWriter("binaryNums.txt"));
        }catch (IOException err) {
            System.out.println(err.getMessage());
            System.exit(2);
        }
    }

    String dataText;

    public fileManager() throws IOException {
    }

    public void getText() {
        String file = "output.txt";
        this.dataText = readTextFromFile(file, ".");
    }

    public String readTextFromFile(String file, String path) {
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
    public void writeFiles(String acepted, String rechazed){
        try{
            writeToFile(acepted,"acepted.txt");
            writeToFile(rechazed,"rechazed.txt");

        }catch (IOException err){
            System.out.println(err.getMessage());
        }

    }
    public void createBinaryFile(){
        try{
            binaryFile.write("");
        }catch (IOException err){
            System.out.println(err.getMessage());
        }
    }
    public void appendBinaryString(String text){
        try{
            binaryFile.append(text);
        }catch (IOException err){
            System.out.println(err.getMessage());
        }
    }


    public void writeToFile(String Text, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(Text);
        writer.close();
    }
}