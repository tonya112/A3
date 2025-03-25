package Interface.Impl;
import Interface.GameBoardable;
import Interface.GameLogical;
import Interface.GreedGameLogic;
import Interface.Viewable;

import java.util.*;

public class GameLogicalImpl implements GreedGameLogic {

    private int xPos;
    private int yPos;
    private MenuItem commandMenuItem;
    private int score;
    private final int orginalXPos;
    private final int orginalYPos;

    public GameLogicalImpl(int xPos, int yPos, MenuItem commandMenuItem) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.commandMenuItem = commandMenuItem;
        this.orginalXPos = xPos;
        this.orginalYPos = yPos;
    }



    @Override
    public boolean nextState(Viewable v) {
        GameBoardable gameBoard = null;
        if(v instanceof GameBoardable){
            gameBoard = (GameBoardable) v;
        }
        //promote
        System.out.println("Enter move option (0 to give up):");

        //check if has nextState
        if(!GreedChecker.hasNextState(gameBoard,this)){
            return false;
        }

        //if still has a way available,call commandMenuItem to update the states
        return commandMenuItem.select(v, this);
    }

    @Override
    public void reset() {
        this.xPos = this.orginalXPos;
        this.yPos = this.orginalYPos;
    }

    @Override
    public void view() {
        System.out.println("Player Score: " + this.score);

    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getXPosition() {
        return this.xPos;
    }

    @Override
    public void setXPosition(int xPosition) {
        this.xPos = xPosition;
    }

    @Override
    public int getYPosition() {
        return this.yPos;
    }

    @Override
    public void setYPosition(int yPosition) {
        this.yPos = yPosition;
    }
}
