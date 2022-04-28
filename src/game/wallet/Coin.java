package game.wallet;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;

public class Coin extends Item {
    private int value;

    public Coin(String name, char displayChar, boolean portable,int value) {
        super(name,displayChar, portable);
        this.value = value;
    }
    public void addSampleAction(Action newAction){
        this.addAction(newAction);
    }
}
