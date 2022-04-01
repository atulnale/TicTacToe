package com.aryannale.model;

import com.aryannale.enums.Symbols;

public class Cell {
    Symbols symbol;

    public Cell(Symbols symbol) {
        this.symbol = symbol;
    }

    public Symbols getSymbol() {
        return symbol;
    }
}
