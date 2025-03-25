import Interface.*;
import Interface.Impl.*;

import java.util.List;

public class GreedGame implements RunnableGame {
    private GameBoardable board;
    private GreedGameLogic game;
    private Menuable menu;
    private boolean isGamemode;
    private Player player;

    public GreedGame() {
        this.player = new HumanPlayer();
        this.board = new GameBoardImpl(20, 30);
        this.game = new GameLogicalImpl(20/2, 30/2, new commandMenuItem("Move", this.player));
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
