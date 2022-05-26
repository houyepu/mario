package game.jumpablegrounds.trees;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Dirt;
import game.Resettable;
import game.Status;
import game.actions.JumpAction;
import game.jumpablegrounds.JumpableGround;

import javax.print.DocFlavor;
import java.util.Random;

/**
 * Abstract class representing different stages of the tree lifecycle.
 */
public abstract class Tree extends JumpableGround implements Resettable {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Tree(char displayChar) {
        super(displayChar);
        this.registerInstance();
        this.addCapability(Status.RESETTABLEGROUND);
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
     * @param actor     the Actor who may be able to jump
     * @param location  the Location the actor is potentially able to jump to
     * @param direction the direction of the high ground from the Actor
     * @return a jump action, if it is a valid jump
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (!location.containsAnActor()) {
            actions.add(new JumpAction(location, direction));
        }
        return actions;
    }

    /**
     * @see JumpableGround
     */
    public String menuDescription(Actor actor, Location location, String direction) {
        return ("Attempt jump " + direction + " to " + location.getGround());
    }

    /**
     * Resets any instance of Tree back to dirt based upon probability
     * @param map       Map on which the trees exist
     */
    @Override
    public void resetInstance(GameMap map) {
        for (int x : map.getXRange()) {
            for (int y : map.getYRange()) {
                if (new Random().nextInt(100) <= 1 && map.at(x, y).getGround().hasCapability(Status.RESETTABLEGROUND)) {
                    map.at(x, y).setGround(new Dirt());
                }
            }
        }
    }
}
