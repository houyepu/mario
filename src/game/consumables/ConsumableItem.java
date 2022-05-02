package game.consumables;

import edu.monash.fit2099.engine.items.Item;
import game.Player;

/**
 * Class representing items that can be consumed
 */
public abstract class ConsumableItem extends Item implements Consumable {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public ConsumableItem(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        this.addAction(new ConsumeAction(this));
    }

    /**
     * Consume the item and remove from inventory
     */
    @Override
    public void consume() {
        Player.getInstance().removeItemFromInventory(this);
    }
}
