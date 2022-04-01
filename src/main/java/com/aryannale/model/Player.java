package com.aryannale.model;

import com.aryannale.enums.Symbols;

public abstract class Player {
    Symbols symbol;
    String name;

    public abstract Move makeMove() ;
}
