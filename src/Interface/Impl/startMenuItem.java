package Interface.Impl;

import Interface.GameLogical;
import Interface.Selectable;
import Interface.Viewable;

public class startMenuItem extends MenuItem{

    public startMenuItem(String description) {
        super(description);
    }
    @Override
    public boolean select(Viewable v, GameLogical gl) {
        return true;
    }
}
