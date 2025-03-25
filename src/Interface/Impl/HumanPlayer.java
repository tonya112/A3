package Interface.Impl;

import Interface.Player;

import java.util.Scanner;

public class HumanPlayer implements Player {

    public int chooseDirection(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
