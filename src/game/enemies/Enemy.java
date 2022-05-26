package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.Resettable;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.MonologueBehaviour;

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
        this.behaviours.put(90, new MonologueBehaviour());
    }

    /**
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return Action for Enemy to take
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // MonologueAction execution
        if (!behaviours.isEmpty()) {
            Action monologueAction = behaviours.get(90).getAction(this, map);
            if (monologueAction != null) {
                System.out.println(monologueAction.execute(this, map));
            }

            // Return valid action from list of behaviours
            for (game.behaviours.Behaviour behaviour : behaviours.values()) {
                if (behaviour != behaviours.get(90)) {
                    Action action = behaviour.getAction(this, map);
                    if (action != null)
                        return action;
                }
            }
        }
        return new DoNothingAction(); // If no action found, do nothing
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
