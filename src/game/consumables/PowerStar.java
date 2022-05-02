package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.Status;

/**
 * Class representing the PowerStar consumable
 */
public class PowerStar extends ConsumableItem {

    /**
     * Turns remaining before PowerStar fades away
     */
    private int powerStarTurnsRemaining;

    /**
     * Constructor
     */
    public PowerStar() {
        super("Power Star", '*', true);
        this.powerStarTurnsRemaining = 10;
    }

    /**
     * Consume the power mushroom -> power up effects
     */
    @Override
    public void consume() {
        super.consume();
        Player.getInstance().heal(200); // Heal the player by 200 points
        Player.getInstance().addCapability(Status.STARPOWERED); // The player now is going to reap the benefits of this item
        System.out.println("MARIO IS INVINCIBLE"); // Print out "MARIO IS INVINCIBLE" to console
    }


    /**
     * Inform an Item on the ground of the passage of time.
     * This method is called once per turn, if the item rests upon the ground.
     *
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        powerStarTurnsRemaining--; // Make the PowerStar a step closer to fading away
        System.out.println("Power star has " + powerStarTurnsRemaining + " turns remaining"); // Print the turns remaining
        if (powerStarTurnsRemaining <= 0)
            currentLocation.removeItem(this); // Remove this item from the location if no turns remaining
    }

    /**
     * Inform a carried Item of the passage of time.
     * <p>
     * This method is called once per turn, if the Item is being carried.
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor           The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        // Same as above except for the actor's inventory
        powerStarTurnsRemaining--;
        System.out.println("Power star has " + powerStarTurnsRemaining + " turns remaining");
        if (powerStarTurnsRemaining <= 0)
            actor.removeItemFromInventory(this); // Remove this item from the actor's inventory if no turns remaining
    }
}
