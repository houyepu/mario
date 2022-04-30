package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.Behaviour;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemy extends Actor {

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
    }
}
