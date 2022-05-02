package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.actions.ConsumeAction;

/**
 * Class representing items that can be consumed
 */
public abstract class ConsumableItem extends Item implements Consumable {

    /**
     * Has the consume action been assigned
     */
    private boolean actionAssigned;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public ConsumableItem(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        actionAssigned = false;
    }

    public boolean isActionAssigned() {
        return actionAssigned;
    }

    public void setActionAssigned(boolean actionAssigned) {
        this.actionAssigned = actionAssigned;
    }

    /**
     * Consume the item and remove from inventory
     */
    @Override
    public void consume() {
        Player.getInstance().removeItemFromInventory(this);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        if (actor.getInventory().contains(this) && !this.isActionAssigned()) {
            togglePortability();
            this.addAction(new ConsumeAction(this));
            this.setActionAssigned(true);
        }
    }
}
