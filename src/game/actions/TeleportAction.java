package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;


public class TeleportAction extends Action {

    public TeleportAction(Location location) {
        super();
        entryPipeLocation = location;
    }

    Location entryPipeLocation;

    public TeleportAction() {

    }


    @Override
    public String execute(Actor actor, GameMap map) {

        map.moveActor(actor, map.at(1,1)); //how to get lava map?
        return (actor + " teleports to the next map!");
    }

    @Override
    public String menuDescription(Actor actor) {
        return (actor + " climbs down the warp pipe, teleporting to another map.");
    }
}
