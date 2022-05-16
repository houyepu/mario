package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.Resettable;
import game.behaviours.FollowBehaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * Class representing enemies
 */
public abstract class Enemy extends Actor implements Resettable {

    /**
     * A map of behaviours (actions) which the AI can perform automatically
     */
    protected final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        registerInstance(); // Sets this as a resettable instance
        this.behaviours.put(10, new AttackBehaviour(Player.getInstance())); // Adds attack behaviour to NPC; sets as highest priority
        this.behaviours.put(20, new FollowBehaviour(Player.getInstance())); // Adds follow behaviour to NPC; sets as medium priority
    }

    /**
     * @return All the behaviours that an enemy may take
     */
    public Map<Integer, Behaviour> getBehaviours() {
        return behaviours;
    }


    /**
     * Resets this instance; removes it from the map
     *
     * @param map The map from which the actor will be removed
     */
    @Override
    public void resetInstance(GameMap map) {
        map.removeActor(this);
    }
}
