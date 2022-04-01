package com.aryannale.model;

import com.aryannale.enums.Symbols;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private List<List<Cell>> board = new ArrayList<>();

    public List<List<Cell>> getBoard() {
         return board;
    }

    public Board(int rows, int cols) {
        for(int i = 0; i< rows; i++) {
            List<Cell> row = new ArrayList<>();
            for(int j = 0; j<cols; j++) {
               row.add(new Cell(null));
            }
            board.add(row);
        }
    }

    public void printBoard() {
        for(int i = 0; i< board.size(); i++) {
            for(int j = 0; j<board.get(0).size(); j++) {
                System.out.print(board.get(i).get(j).symbol + "\t");
            }
            System.out.println();
        }
    }
}
