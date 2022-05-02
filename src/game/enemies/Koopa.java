package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.*;
import game.actions.AttackAction;
import game.actions.ExecuteAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.consumables.SuperMushroom;

/**
 * A shelled-trooper
 */
public class Koopa extends Enemy {

    /**
     * Constructor
     *
     * @see Enemy
     */
    public Koopa() {
        super("Koopa", 'K', 100);
        this.behaviours.put(10, new AttackBehaviour(Player.getInstance())); // Adds attack behaviour to NPC; sets as highest priority
        this.behaviours.put(20, new FollowBehaviour(Player.getInstance())); // Adds follow behaviour to NPC; sets as medium priority
        this.behaviours.put(30, new WanderBehaviour()); // Adds wander behaviour to NPC; sets as lowest priority
        this.addItemToInventory(new SuperMushroom()); // Adds a super mushroom to the inventory of the Koopa (drops when killed)
    }

    /**
     * @return IntrinsicWeapon of the Koopa
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30, "punches");
    }

    /**
     * At the moment, we only make it can be attacked by Player.
     * You can do something else with this method.
     *
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     * @see Status#HOSTILE_TO_ENEMY
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList(); // List of potential actions against this actor
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
            // If the other actor is not STARPOWERED, don't allow execute action since it will be killed immediately
            if (!this.isConscious() && !otherActor.hasCapability(Status.STARPOWERED)) {
                actions.add(new ExecuteAction(this, direction, "wrenches"));
            }
            this.addCapability(Status.DORMANT); // Allow for this actor to go dormant (avoid death until executed)
        }
        return actions;
    }

    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (game.behaviours.Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     *
     * @return The display character that reflects whether the Koopa is unconscious
     */
    @Override
    public char getDisplayChar() {
        // If the actor isn't conscious
        if (!isConscious()) {
            return 'D';
        } else {
            return super.getDisplayChar();
        }
    }
}
