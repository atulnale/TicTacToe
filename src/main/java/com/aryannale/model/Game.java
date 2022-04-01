package com.aryannale.model;

import com.aryannale.enums.Symbols;
import com.aryannale.exceptions.InvalidPlayersCountExceptions;
import com.aryannale.exceptions.SameSymbolSelectedException;
import com.aryannale.strategies.winning.IWinningStrategy;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>();
    private IWinningStrategy winningStrategy;
    private boolean finished;
    private HashMap<Symbols,Player> symbolsPlayerHashMap = new HashMap<>();

    private Game() {

    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public IWinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(IWinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public void printBoard() {
        board.printBoard();
    }

    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }

    public void start() {

        int count = 0;
        int playerTurn = 0;
        while(count != 9 && !finished ) {
            Player currentPlayer = players.get(playerTurn);
                Move move = currentPlayer.makeMove();
                board.getBoard().get(move.getI()).set(move.getJ(), new Cell(currentPlayer.symbol));
                printBoard();
                playerTurn = (playerTurn + 1 ) % 2;
            Player winner = winningStrategy.checkWinner(board, symbolsPlayerHashMap);
            if(winner != null) {
                    finished = true;
                    System.out.println(" ********  " + winner.name + " has won the game  ****");
                    return;
                }
                count++;
        }
        System.out.println(" ********  Tie  *******");
    }

    public static class GameBuilder {
        private Game game;
        private int rows;
        private int cols;

        GameBuilder() {
            game = new Game();
        }

        public GameBuilder addPlayer(Player player) {
            game.getPlayers().add(player);
            return this;
        }
        public GameBuilder addWinningStrategy(IWinningStrategy winningStrategy) {
            game.setWinningStrategy(winningStrategy);
            return this;
        }
        public GameBuilder setRows(int rows) {
            this.rows = rows;
            return this;
        }
        public GameBuilder setCols(int cols) {
            this.cols = cols;
            return this;
        }

        public Game build() {
            game.finished = false;
            if(game.getPlayers().size() < 2) {
                throw new InvalidPlayersCountExceptions();
            }
            Board board = new Board(rows,cols);
            Set<Symbols> set = new HashSet<>();
            for(Player player: game.getPlayers()) {
                this.game.symbolsPlayerHashMap.put(player.symbol,player);
                if(set.contains(player.symbol)) {
                    throw new SameSymbolSelectedException();
                }
                set.add(player.symbol);
            }
            game.setBoard(board);

            return game;
        }
    }
}
