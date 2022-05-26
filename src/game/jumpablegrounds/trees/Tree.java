package game.jumpablegrounds.trees;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;
import game.Status;
import game.actions.JumpAction;
import game.jumpablegrounds.JumpableGround;

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
        registerInstance();
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

    @Override
    public void resetInstance(GameMap map) {

    }
}
