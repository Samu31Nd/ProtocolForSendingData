package org.example;

import java.io.*;

public class fileManager {
    BufferedWriter binaryFile;


    public void writeFiles(String accepted, String rejected){
        try{
            writeToFile(accepted,"accepted.txt");
            writeToFile(rejected,"rejected.txt");

        }catch (IOException err){
            System.out.println(err.getMessage());
        }

    }
    public void createBinaryFile(){
        try{
            binaryFile = new BufferedWriter(new FileWriter("binaryNums.txt"));
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

    public void closeBinaryFile(){
        try{
            binaryFile.close();
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