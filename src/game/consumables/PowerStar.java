package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.Status;

/**
 * Class representing the PowerStar consumable
 */
public class PowerStar extends ConsumableItem{

    /**
     * Turns remaining before PowerStar fades away
     */
    private int powerStarFadeTime;

    /**
     * Constructor
     */
    public PowerStar() {
        super("Power Star", '*', true);
        this.powerStarFadeTime = 10;
    }

    /**
     * Consume the power mushroom -> power up effects
     */
    @Override
    public void consume() {
        super.consume();
        Player.getInstance().increaseMaxHp(200);
        Player.getInstance().addCapability(Status.STARPOWERED);
        System.out.println("MARIO IS INVINCIBLE");
    }


    /**
     * Inform an Item on the ground of the passage of time.
     * This method is called once per turn, if the item rests upon the ground.
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        powerStarFadeTime--;
        System.out.println("Power star has " + powerStarFadeTime + " turns remaining");
        if (powerStarFadeTime <= 0)
            currentLocation.removeItem(this);
    }

    /**
     * Inform a carried Item of the passage of time.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        powerStarFadeTime--;
        System.out.println("Power star has " + powerStarFadeTime + " turns remaining");
        if (powerStarFadeTime <= 0)
            actor.removeItemFromInventory(this);
    }
}
