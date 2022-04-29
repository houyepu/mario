package game.toad;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.Behaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * Toad that speaks to the player and sells drugs :)
 */
public class Toad extends Actor {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    /**
     * Constructor.
     */
    public Toad() {
        super("Toad", 'O', 10000);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
