package game.allies;

import edu.monash.fit2099.engine.actors.Actor;
import game.behaviours.Behaviour;
import game.behaviours.MonologueBehaviour;

import java.util.HashMap;
import java.util.Map;

public abstract class Ally extends Actor {

    protected final Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Ally(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        behaviours.put(10, new MonologueBehaviour());
    }
}
