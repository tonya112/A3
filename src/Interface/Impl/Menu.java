package Interface.Impl;

import Interface.Menuable;
import Interface.Selectable;
import Interface.Viewable;

import java.util.List;
import java.util.Scanner;

public class Menu implements Menuable {

    private boolean gameStart;

    private List<MenuItem> menuItems;
    private String message;

    public Menu(List<MenuItem> menuItems, String message)
    {
        this.menuItems = menuItems;
        this.message = message;
    }

    @Override
    public boolean nextState(Viewable v) {
        for (int i = 0; i < menuItems.size(); i++){
            int index = i + 1;
            System.out.println(index + ". " + menuItems.get(i).getDescription());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select an option: ");
        int selectedOption = scanner.nextInt();
        return menuItems.get(selectedOption - 1).select(v, this);

    }

    @Override
    public void reset() {

    }

    @Override
    public void view() {
        System.out.println(this.message);
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
