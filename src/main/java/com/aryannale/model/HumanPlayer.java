package com.aryannale.model;

import com.aryannale.InputReader;
import com.aryannale.enums.Symbols;

public class HumanPlayer extends Player{
    User user;

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public Move makeMove() {
        System.out.println(" **** "+user.getName()+ "! please play your turn ***");
        return InputReader.getInputReader().readInput();
    }

    public static class Builder{
        private HumanPlayer humanPlayer;
        public Builder() {
            this.humanPlayer = new HumanPlayer();
        }
        public Builder setUser(User user) {
            this.humanPlayer.user = user;
            this.humanPlayer.name = user.getName();
            return this;
        }
        public Builder setSymbol(Symbols symbol){
            this.humanPlayer.symbol = symbol;
            return this;
        }


        public HumanPlayer build() {
            return this.humanPlayer;
        }
    }
}
