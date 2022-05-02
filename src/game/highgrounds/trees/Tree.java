package game.highgrounds.trees;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.JumpAction;
import game.highgrounds.HighGround;


public abstract class Tree extends HighGround {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Tree(char displayChar) {
        super(displayChar);
    }

    int jumpSuccessChance;
    int jumpFailureDamage;

    public int getJumpSuccessChance() {
        return jumpSuccessChance;
    }

    public int getJumpFailureDamage() {
        return jumpFailureDamage;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.STARPOWERED);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (!location.containsAnActor()) {
            actions.add(new JumpAction(location, direction));
        }
        return actions;
    }

    public String menuDescription(Actor actor, Location location, String direction) {
        return ("Attempt jump " + direction + " to " + location.getGround());
    }
}
