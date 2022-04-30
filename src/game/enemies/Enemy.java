package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.Behaviour;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemy extends Actor {

    protected final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    protected final Actor player;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param player      the Actor the enemy should target
     */
    public Enemy(String name, char displayChar, int hitPoints, Actor player) {
        super(name, displayChar, hitPoints);
        this.player = player;
    }
}
