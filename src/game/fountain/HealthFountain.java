package game.fountain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.FillHealthWaterAction;

public class HealthFountain extends Ground {
    /**
     * Constructor.
     *
     */
    public HealthFountain() {
        super('H');
    }
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new FillHealthWaterAction());
        }
        return actions;
    }
}
