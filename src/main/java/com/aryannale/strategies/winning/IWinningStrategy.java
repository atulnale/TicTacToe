package com.aryannale.strategies.winning;

import com.aryannale.enums.Symbols;
import com.aryannale.model.Board;
import com.aryannale.model.Player;

import java.util.HashMap;

public interface IWinningStrategy {
    Player checkWinner(Board b, HashMap<Symbols,Player> map);
}
