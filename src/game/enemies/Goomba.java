package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.*;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.MonologueBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.Random;

/**
 * A little fungus guy.
 */
public class Goomba extends Enemy {

    /**
     * The probability/chance of a Goomba committing suicide
     */
    private final int suicideRate = 10;

    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     *
     * @see Enemy
     */
    public Goomba() {
        super("Goomba", 'g', 20);
        this.behaviours.put(20, new FollowBehaviour(Player.getInstance())); // Adds follow behaviour to NPC; sets as medium priority
        this.behaviours.put(30, new WanderBehaviour()); // Adds wander behaviour to NPC; sets as lowest priority
        //this.behaviours.put(40, new MonologueBehaviour());
    }

    /**
     * @return IntrinsicWeapon of the Goomba
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "kicks");
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
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
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
        // If the random integer is less than the suicide rate; remove this actor
        if (rand.nextInt(100) <= getSuicideRate()) {
            map.removeActor(this);
            System.out.println("Goomba was depressed and decided he couldn't take Mario's abuse any longer");
            return new DoNothingAction();
        }

        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * @return The chance of a goomba committing suicide
     */
    public int getSuicideRate() {
        return suicideRate;
    }
}
