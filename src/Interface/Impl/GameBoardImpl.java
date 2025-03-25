package Interface.Impl;

import Interface.GameBoardable;

import java.util.Random;

public class GameBoardImpl implements GameBoardable {
    private final Integer xSize;
    private final Integer ySize;
    private char [][] board;

    public GameBoardImpl(Integer xSize, Integer ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.board = new char[xSize][ySize];
        this.init();
    }

    private void init() {
        Random random = new Random();
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                board[i][j] = (char) ('1' + random.nextInt(9));
            }
        }
        int playerX = xSize/2;
        int playerY = ySize/2;
        board[playerX][playerY] = '@';
    }
    @Override
    public void view() {
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public char getValue(int x, int y) {
        return board[x][y];
    }

    @Override
    public void setValue(int x, int y, char value) {
        this.board[x][y] = value;
    }

    @Override
    public int getXSize() {
        return xSize;
    }

    @Override
    public int getYSize() {
        return ySize;
    }

    @Override
    public void reset() {
        init();
    }
}
