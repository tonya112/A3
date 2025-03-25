package Interface.Impl;

import Interface.GameBoardable;
import Interface.GreedGameLogic;

import java.util.*;

public class GreedChecker {

    private static final Map<Integer, int[]> MOVE_OFFSET = new HashMap<>();
    static {
        MOVE_OFFSET.put(1, new int[]{1, -1});
        MOVE_OFFSET.put(2, new int[]{1, 0});
        MOVE_OFFSET.put(3, new int[]{1, 1});
        MOVE_OFFSET.put(4, new int[]{0, -1});
        MOVE_OFFSET.put(6, new int[]{0, 1});
        MOVE_OFFSET.put(7, new int[]{-1, -1});
        MOVE_OFFSET.put(8, new int[]{-1, 0});
        MOVE_OFFSET.put(9, new int[]{-1, 1});
    }

    public static boolean hasNextState(GameBoardable gameBoard, GreedGameLogic greedGameLogic){
        //check if has nextState
        Map<Integer, List<Integer>> movementMap = new HashMap<>();
        movementMap.put(1, isMovementPossible(gameBoard, greedGameLogic, 1));
        movementMap.put(2, isMovementPossible(gameBoard, greedGameLogic,2));
        movementMap.put(3, isMovementPossible(gameBoard, greedGameLogic,3));
        movementMap.put(4, isMovementPossible(gameBoard, greedGameLogic,4));
        movementMap.put(6, isMovementPossible(gameBoard, greedGameLogic,6));
        movementMap.put(7, isMovementPossible(gameBoard, greedGameLogic,7));
        movementMap.put(8, isMovementPossible(gameBoard, greedGameLogic,8));
        movementMap.put(9, isMovementPossible(gameBoard, greedGameLogic,9));

        //if all ways are invalid,return false
        if(movementMap.values().stream().allMatch(Objects::isNull)){
            System.out.println("No more moves");
            return false;
        }
        return true;
    }


    public static List<Integer> isMovementPossible(GameBoardable gameBoard, GreedGameLogic greedGameLogic, int direction){


        if(MOVE_OFFSET.get(direction) == null){
            return null;
        }

        int xOffset = MOVE_OFFSET.get(direction)[0];
        int yOffset = MOVE_OFFSET.get(direction)[1];

        //check if has step
        int xPos = greedGameLogic.getXPosition();
        int yPos = greedGameLogic.getYPosition();


        int xbound = gameBoard.getXSize()-1;
        int ybound = gameBoard.getYSize()-1;
        if(xPos+xOffset > xbound || xPos+xOffset < 0 || yPos+yOffset < 0 || yPos+yOffset > ybound){

            return null;
        }

        //if has step
        int step = gameBoard.getValue(xPos+xOffset, yPos+yOffset) - '0';
        int xAfterMovement = xPos + xOffset * step;
        int yAfterMovement = yPos + yOffset * step;

        if(xAfterMovement < 0 || xAfterMovement > xbound || yAfterMovement < 0 || yAfterMovement > ybound){

            return null;
        }

        int currentX = xPos;
        int currentY = yPos;


        while(currentX != xAfterMovement || currentY != yAfterMovement){
            currentX += xOffset;
            currentY += yOffset;
            if(gameBoard.getValue(currentX, currentY) == ' '){
                return null;
            }
        }


        if(gameBoard.getValue(xAfterMovement, yAfterMovement) == ' '){
            //System.out.println("direction: " + direction + "step: " + step + " movement Out of bound + null char " + " xAfter: " + xAfterMovement + " yAfter: " + yAfterMovement);
            return null;
        }

        List<Integer> movementList = new ArrayList<>();
        movementList.add(xAfterMovement);
        movementList.add(yAfterMovement);

        return movementList;
    }

    public static void moveAndUpdate(GameBoardable gameBoard, GreedGameLogic greedGameLogic, int direction){

        if(MOVE_OFFSET.get(direction) == null){
            return;
        }
        int xOffset = MOVE_OFFSET.get(direction)[0];
        int yOffset = MOVE_OFFSET.get(direction)[1];

        int xPos = greedGameLogic.getXPosition();
        int yPos = greedGameLogic.getYPosition();

        int step = gameBoard.getValue(xPos+xOffset, yPos+yOffset) - '0';
        int xAfterMovement = xPos + xOffset * step;
        int yAfterMovement = yPos + yOffset * step;


        while(xPos != xAfterMovement || yPos != yAfterMovement){
            gameBoard.setValue(xPos, yPos, ' ');
            xPos += xOffset;
            yPos += yOffset;
        }
        gameBoard.setValue(xPos, yPos, '@');
        greedGameLogic.setXPosition(xPos);
        greedGameLogic.setYPosition(yPos);
        greedGameLogic.setScore(greedGameLogic.getScore() + step);
    }
}
