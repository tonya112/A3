package Interface.Impl;

import Interface.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class commandMenuItem extends MenuItem{

    private Player player;

    public commandMenuItem(String description, Player player) {
        super(description);
        this.player = player;
    }

    @Override
    public boolean select(Viewable v, GameLogical gl) {
        GameBoardable gameBoard = null;
        if(v instanceof GameBoardable){
            gameBoard = (GameBoardable) v;
        }

        GreedGameLogic greedGameLogic = null;
        if(gl instanceof GreedGameLogic){
            greedGameLogic = (GreedGameLogic) gl;
        }

        int direction = this.player.chooseDirection();

        if(direction == 0){
            return false;
        }

        if(direction > 9 || direction < 0){
            System.out.println("Invalid input! try 0~9");
            return select(v,gl);
        }

        List<Integer> destination = GreedChecker.isMovementPossible(gameBoard,greedGameLogic,direction);
        if(destination == null){
            System.out.println("That is an invalid move. Try again.");
            return true;
        }

        GreedChecker.moveAndUpdate(gameBoard,greedGameLogic,direction);

        return true;
    }
}
