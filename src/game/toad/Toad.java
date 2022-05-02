package game.toad;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.Behaviour;
import game.actions.MonologueAction;
import game.actions.TradePowerStarAction;
import game.actions.TradeSuperMushroomAction;
import game.actions.TradeWrenchAction;

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
        super("Toad", 'B', 10000);
    }

    /**
     * Toad will do nothing for each playTurn
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return action    the action which will be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * Toad can talk to the player and trade with the player
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // Toad has 4 actions
        actions.add(new MonologueAction(this));
        actions.add(new TradePowerStarAction(this));
        actions.add(new TradeSuperMushroomAction(this));
        actions.add(new TradeWrenchAction(this));

        return actions;
    }
}
