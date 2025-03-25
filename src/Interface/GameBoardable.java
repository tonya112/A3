package Interface;

public interface GameBoardable extends Viewable{
    char getValue(int x, int y);

    void setValue(int x, int y, char value);

    int getXSize();

    int getYSize();

    void reset();


}
