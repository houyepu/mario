package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Key;
import game.Player;
import game.Status;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.behaviours.MonologueBehaviour;

public class Bowser extends Enemy {

    private boolean isResting;

    /**
     * Constructor.
     */
    public Bowser() {
        super("Bowser", 'B', 500);
        this.addCapability(Status.FIREPOWERED);
        this.isResting = true;
        this.behaviours.put(20, new FollowBehaviour(Player.getInstance())); // Adds follow behaviour to NPC; sets as medium priority
        this.addItemToInventory(new Key()); // Adds a key to the inventory of Bowser (drops when killed)
    }

    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "punches");
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Action monologueAction = behaviours.get(90).getAction(this, map);
        if (monologueAction != null) {
            System.out.println(monologueAction.execute(this, map));
        }

        Location here = map.locationOf(this);

        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                isResting = false;
            }
        }

        for (game.behaviours.Behaviour behaviour : behaviours.values()) {
            if (behaviour != behaviours.get(90) && !isResting) {
                Action action = behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }
        return new DoNothingAction();
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    @Override
    public void registerInstance() {
        super.registerInstance();
    }
}
