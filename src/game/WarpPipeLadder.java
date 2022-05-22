package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;

public class WarpPipeLadder extends Item {

    public WarpPipeLadder() {
        super("WarpPipe", 'c', false);
    }

    public void addSampleAction(Action newAction){
        this.addAction(newAction);
    }
}
