package com.aryannale;

import com.aryannale.model.Move;

import java.util.Scanner;

public class InputReader {
    static final Scanner sc = new Scanner(System.in);
    static InputReader instance;
    private InputReader(){}
    public static synchronized InputReader getInputReader() {
        if(instance == null) instance = new InputReader();
        return instance;
    }
    public Move readInput() {
        int i = sc.nextInt();
        int j = sc.nextInt();
        return new Move(i,j);
    }
}
