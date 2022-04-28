package game.wallet;

import edu.monash.fit2099.engine.items.Item;

public class Coin extends Item {
    private int value;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Coin(String name, char displayChar, boolean portable,int value) {
        super(name,displayChar, portable);
        this.value = value;
    }
}
