package com.aryannale;

import com.aryannale.enums.Symbols;
import com.aryannale.factories.PlayerFactory;
import com.aryannale.model.Game;
import com.aryannale.model.HumanPlayer;
import com.aryannale.model.User;
import com.aryannale.strategies.winning.DefaultWinningStrategyImpl;

public class Client {
    public static void main(String[] args) {

        Game game = Game.getBuilder()
                .addPlayer(PlayerFactory.createHumanPlayer().setSymbol(Symbols.X).setUser(new User("Player 1")).build())
                .addPlayer(PlayerFactory.createHumanPlayer().setSymbol(Symbols.Y).setUser(new User("Player 2")).build())
                .addWinningStrategy(new DefaultWinningStrategyImpl())
                .setCols(3)
                .setRows(3)
                .build();
        game.start();


    }
}
