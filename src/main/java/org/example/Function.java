package org.example;

public class Function {
    int currentState = 0,
    strokeLine = 0;
    public int Moviment(int n){
        if(n == 0){
            switch (currentState){
                case 0 -> {
                    currentState = 2;
                    strokeLine = 6;
                }
                case 1 ->{
                    currentState = 3;
                    strokeLine = 3;
                }
                case 2 ->{
                    currentState = 0;
                    strokeLine = 1;
                }
                case 3 ->{
                    currentState = 1;
                    strokeLine = 5;
                }
            }
        } else if(n == 1){
            switch (currentState){
                case 0 -> {
                    currentState = 1;
                    strokeLine = 0;
                }
                case 1 ->{
                    currentState = 0;
                    strokeLine = 4;
                }
                case 2 ->{
                    currentState = 3;
                    strokeLine = 7;
                }
                case 3 ->{
                    currentState = 2;
                    strokeLine = 2;
                }

            }
        } else throw new IllegalStateException("Unexpected value: " + currentState);
        return currentState;
    }
}
