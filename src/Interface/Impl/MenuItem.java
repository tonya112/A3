package Interface.Impl;

import Interface.GameLogical;
import Interface.Selectable;
import Interface.Viewable;

public abstract class MenuItem implements Selectable {

    private String description;

    public MenuItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}
