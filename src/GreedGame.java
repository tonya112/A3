import Interface.GameBoardable;
import Interface.GreedGameLogic;
import Interface.Impl.*;
import Interface.Menuable;
import Interface.RunnableGame;

import java.util.List;

public class GreedGame implements RunnableGame {
    private GameBoardable board;
    private GreedGameLogic game;
    private Menuable menu;
    private boolean isGamemode;

    public GreedGame() {
        this.board = new GameBoardImpl(20, 30);
        this.game = new GameLogicalImpl(20/2, 30/2, new commandMenuItem("Move"));
        List<MenuItem> menuItems = List.of(
                new startMenuItem("Start"),
                new exitMenuItem("Exit")
        );
        this.menu = new Menu(menuItems, "Welcome to Greed!");
        this.isGamemode = false;
    }
    @Override
    public void run() {
        while (true) {
            menu.view();
            isGamemode = menu.nextState(menu);
            while ( isGamemode ) {
                game.view();
                board.view();
                isGamemode = game.nextState(board);
            }
            menu.setMessage("Welcome back!");
            menu.reset();
            board.reset();
            game.reset();
        }

    }
}
