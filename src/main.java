import Interface.Impl.*;
import Interface.Player;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Player player = new HumanPlayer();
        GameBoard gb = new GameBoardImpl(20, 30);
        GameLogic gl = new GameLogicalImpl(20/2, 30/2, new commandMenuItem("Move", player));
        List<MenuItem> menuItems = List.of(
                new startMenuItem("Start"),
                new exitMenuItem("Exit")
        );
        Menu m = new Menu(menuItems, "Welcome to Greed!");
        GreedGame greedGame = new GreedGame(gl,gb,m,player);
        greedGame.run();
    }
}
