package game.fountain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.FillPowerWaterAction;

public class PowerFountain extends Ground {
    /**
     * Constructor.
     *
     */
    public PowerFountain() {
        super('A');
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new FillPowerWaterAction());
        }
        return actions;
    }
}
