package com.aryannale.factories;

import com.aryannale.model.HumanPlayer;
import com.aryannale.model.Player;

public class PlayerFactory {
    public static HumanPlayer.Builder createHumanPlayer() {
        return HumanPlayer.getBuilder();
    }
}
