package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Utils {
    static boolean genRanBool() {
        return (new Random().nextInt(11) > 8 ? false : true);
    }

    static int genIntBool() {
        return new Random().nextInt(2);
    }

    static String generateBinary() {
        String binary = "";
            for(int j = 0; j < 64; j++)
            binary += (new Random().nextBoolean())?'0':'1';

        System.out.println(binary);
        return binary;
    }

    private static void writeToFile(String Text, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(Text);
        writer.close();
    }

}
