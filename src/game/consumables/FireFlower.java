package game.consumables;

public class FireFlower extends ConsumableItem{
    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public FireFlower(String name, char displayChar, boolean portable) {
        super("Fire Flower", 'f', true);
    }
}
