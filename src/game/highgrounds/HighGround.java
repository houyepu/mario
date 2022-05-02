package game.highgrounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Dirt;
import game.Player;
import game.Status;
import game.actions.JumpAction;
import game.wallet.Coin;

/**
 * Abstract class representing every piece of ground that cannot be walked onto but can be jumped onto.
 */
public abstract class HighGround extends Ground {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public HighGround(char displayChar) {
        super(displayChar);
    }

    /**
     * Success chance (as a percentage) to jump onto this
     */
    int jumpSuccessChance;
    /**
     * Damage taken by failing to jump onto this object
     */
    int jumpFailureDamage;

    public int getJumpSuccessChance() {
        return jumpSuccessChance;
    }

    public int getJumpFailureDamage() {
        return jumpFailureDamage;
    }

    /**
     *
     * @param actor the Actor to check if it can enter the tile
     * @return if the player is able to walk onto the tile
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.STARPOWERED);
    } //only allowed to walk onto high ground without a jump if you are star powered.

    /**
     *
     * @param actor the Actor who may be able to jump
     * @param location the Location the actor is potentially able
     * @param direction the direction of the high ground from the Actor
     * @return nothing, or a new jump action to a high ground if valid
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (!location.containsAnActor() && !actor.hasCapability(Status.STARPOWERED)) {
            // location must be empty to jump to.
            // Also, star powered actors shouldn't have a jump action as they can just walk over high ground
            actions.add(new JumpAction(location, direction));
        }
        return actions;
    }

    /**
     *
     * @param location The location of the Ground that is being influenced by the passage of time (or potentially destroyed).
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        /*
        if there is a star powered player on a high ground tile, destroy the highground (replace with dirt)
        and then spawn a $5 coin
         */
        if (location.containsAnActor() && Player.getInstance().hasCapability(Status.STARPOWERED)) {
            location.setGround(new Dirt());
            location.addItem(new Coin("coin",'$',true,5));
        }
    }

    /**
     *
     * @param location location object the player is able to jump to
     * @param direction where the location to jump to is, relative to the player
     * @return a jump action to the console that the user can make the Player perform
     */
    public String menuDescription(Location location, String direction) {
        return ("Attempt jump " + direction + " to " + location.getGround());
    }
}


