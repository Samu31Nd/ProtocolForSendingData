package org.example;

import java.util.Random;

public class Utils {
    static boolean genRanBool() {
        return (new Random().nextInt(11) <= 8);
    }


    static String generateBinary() {
        StringBuilder binary = new StringBuilder();
            for(int j = 0; j < 64; j++)
                binary.append((new Random().nextBoolean()) ? '0' : '1');
        System.out.println(binary);
        return binary.toString();
    }

}
