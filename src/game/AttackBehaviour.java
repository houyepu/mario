package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Special behaviour for AI that allows them to attack the player automatically
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Reference to the player that will be targeted
     */
    private final Actor player;

    /**
     * Constructor
     * @param actor     The player actor
     */
    public AttackBehaviour(Actor actor) {
        this.player = actor;
    }

    /**
     * Retrieves the AttackAction needed to attack the player
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return the AttackAction which targets the player
     */
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
