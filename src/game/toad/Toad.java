package game.toad;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.AttackAction;
import game.Behaviour;
import game.Status;
import game.actions.MonologueAction;
import game.actions.TradeWithToadAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Toad that speaks to the player and sells drugs :)
 */
public class Toad extends Actor {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    /**
     * Toad is an actor
     */
    public Toad() {
        super("Toad", 'O', 10000);
    }

    /**
     * Toad will do nothing for each playTurn
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.

        actions.add(new MonologueAction(this));
        actions.add(new TradeWithToadAction(this));

        return actions;
    }
}
