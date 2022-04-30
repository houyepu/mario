package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class AttackBehaviour implements Behaviour {

    private final Actor player;

    public AttackBehaviour(Actor actor) {
        this.player = actor;
    }

    // TODO: develop and use it to attack the player automatically.
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if(!map.contains(player) || !map.contains(actor))
            return null;

        Location here = map.locationOf(actor);

        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                return new AttackAction(player, exit.getName());
            }
        }

        return null;
    }
}
