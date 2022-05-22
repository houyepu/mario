package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Key;
import game.Monologue;
import game.Player;
import game.Status;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.consumables.SuperMushroom;

public class Bowser extends Enemy{
    private Monologue monologue;
    /**
     * Constructor.
     */
    public Bowser() {
        super("Bowser", 'B', 500);
        this.behaviours.put(20, new FollowBehaviour(Player.getInstance())); // Adds follow behaviour to NPC; sets as medium priority
        this.addItemToInventory(new Key()); // Adds a key to the inventory of Bowser (drops when killed)
    }

    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "punches");
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
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (game.behaviours.Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public void registerInstance() {
        super.registerInstance();
    }
}
