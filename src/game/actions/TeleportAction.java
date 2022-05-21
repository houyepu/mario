package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class TeleportAction extends Action {

    public TeleportAction(Location location) {
        super();
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return (actor + " teleports to the next map!");
    }

    @Override
    public String menuDescription(Actor actor) {
        return (actor + " climbs down the warp pipe, teleporting to another map.");
    }
}
