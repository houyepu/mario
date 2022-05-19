package game.fountain;

import game.Player;
import game.consumables.ConsumableItem;

public abstract class Water extends ConsumableItem implements Fillwater{
    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Water(String name, char displayChar, boolean portable) {
        super(name,displayChar,portable);
    }

    @Override
    public void fill() {
        Player.Bottle.push(this);
    }
}
