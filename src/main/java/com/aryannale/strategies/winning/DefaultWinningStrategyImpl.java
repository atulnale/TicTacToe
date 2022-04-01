package com.aryannale.strategies.winning;

import com.aryannale.enums.Symbols;
import com.aryannale.model.Board;
import com.aryannale.model.Cell;
import com.aryannale.model.Player;

import java.util.HashMap;
import java.util.List;

public class DefaultWinningStrategyImpl implements IWinningStrategy {
    @Override
    public Player checkWinner(Board b, HashMap<Symbols,Player> map) {

        List<List<Cell>> boardList = b.getBoard();
        for(int i = 0; i< 3; i++) {
            if((boardList.get(i).get(0).getSymbol() != null) && boardList.get(i).get(0).getSymbol() == boardList.get(i).get(1).getSymbol() && boardList.get(i).get(1).getSymbol() == boardList.get(i).get(2).getSymbol())
                return map.get(boardList.get(i).get(0).getSymbol());
        }
        for(int i = 0; i< 3; i++) {
            if( (boardList.get(0).get(i).getSymbol() != null) && boardList.get(0).get(i).getSymbol() == boardList.get(1).get(i).getSymbol() && boardList.get(1).get(i).getSymbol() == boardList.get(2).get(i).getSymbol())
            return map.get(boardList.get(0).get(i).getSymbol());
        }
        if((boardList.get(0).get(0).getSymbol() != null) && boardList.get(0).get(0).getSymbol() == boardList.get(1).get(1).getSymbol() && boardList.get(1).get(1).getSymbol() == boardList.get(2).get(2).getSymbol())
            return map.get(boardList.get(0).get(0).getSymbol());
        if((boardList.get(0).get(2).getSymbol() != null) && boardList.get(0).get(2).getSymbol() == boardList.get(1).get(1).getSymbol() && boardList.get(1).get(1).getSymbol() == boardList.get(2).get(0).getSymbol())
            return map.get(boardList.get(0).get(2).getSymbol());

        return null;
    }
}
