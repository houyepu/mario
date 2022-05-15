package game.fountain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.*;

public class HealthFountain extends Ground {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public HealthFountain(char displayChar) {
        super('H');
    }
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();

        actions.add(new FillwaterAction());

        return actions;
    }
}
