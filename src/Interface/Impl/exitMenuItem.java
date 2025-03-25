package Interface.Impl;

import Interface.GameLogical;
import Interface.Viewable;

public class exitMenuItem extends MenuItem{

    public exitMenuItem(String description) {
        super(description);
    }
    @Override
    public boolean select(Viewable v, GameLogical gl) {
        System.exit(0);
        return false;
    }
}
