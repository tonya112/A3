import Interface.*;
import Interface.Impl.*;

import java.util.List;

public class GreedGame extends Game {
//    private GameBoardable board;
//    private GreedGameLogic game;
//    private Menuable menu;
//    private boolean isGamemode;
    private Player player;

    public GreedGame(GameLogic gl, GameBoard gb, Menu m, Player player) {
        super(gl, gb, m);
        this.player = player;

    }

}
