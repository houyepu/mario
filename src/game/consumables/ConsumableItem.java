package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.Status;
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

    /**
     * @return Whether the consume action has been assigned to this consumable (able to be consumed)
     */
    public boolean isActionAssigned() {
        return actionAssigned;
    }

    /**
     * @param actionAssigned Set whether the consume action has been assigned to this consumable
     */
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


    /**
     * Tick method overridden by this actor; makes item in actors inventory aware of the passage of time
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor           The actor carrying this Item.
     * @see Item#tick(Location, Actor)
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        // If the actor has the consumable, is not yet able to be consumed and the actor is HOSTILE_TO_ENEMY (player)
        if (actor.getInventory().contains(this) && !this.isActionAssigned() && actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            togglePortability(); // Make it so that player can no longer drop the item
            this.addAction(new ConsumeAction(this)); // Show the consume action in the menu of the player
            this.setActionAssigned(true); // Set to be true so that the consumable action is only assigned once
        }
    }
}
