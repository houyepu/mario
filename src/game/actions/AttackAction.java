package game.actions;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Status;
import game.enemies.Koopa;
import game.highgrounds.trees.Sprout;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    protected Actor target;

    /**
     * The direction of incoming attack.
     */
    protected String direction;

    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param direction the direction this actor is facing
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A string showing the outcome
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        Weapon weapon = actor.getWeapon(); // Get the weapon of the actor

        // If the random number is less than the chance the weapon has to hit -> miss
        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        // If the target of the AttackAction is STARPOWERED, make them invincible
        if (target.hasCapability(Status.STARPOWERED)) {
            return actor + " can't hit the invincible " + target + ".";
        }

        // If the one doing the AttackAction is STARPOWERED, make them insta-kill the enemy
        if (actor.hasCapability(Status.STARPOWERED)) {
            ActionList dropActions = new ActionList();
            // drop all items
            for (Item item : target.getInventory())
                dropActions.add(item.getDropAction(actor));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
            return "The target cannot withstand the force of the Power Star";
        }

        int damage = weapon.damage(); // Gets the damage of the weapon
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage."; // Print to console
        target.hurt(damage); // Inflict damage upon the target
        target.removeCapability(Status.SHROOMPOWERED); // Remove the SHROOMPOWERED status since the actor has been hit
        // If the actor is unconscious and does not have the ability to go DORMANT
        if (!target.isConscious() && !target.hasCapability(Status.DORMANT)) {
            ActionList dropActions = new ActionList();
            // drop all items
            for (Item item : target.getInventory())
                dropActions.add(item.getDropAction(actor));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
            result += System.lineSeparator() + target + " is killed.";
        } else if (!target.isConscious() && target.hasCapability(Status.DORMANT)) {
            // Will clear behaviours of target if it is made unconscious and has the ability to go DORMANT
            ((Koopa) target).getBehaviours().clear();
            result += System.lineSeparator() + target + " is dormant.";
        }

        return result;
    }

    /**
     * @param actor The actor performing the action.
     * @return The way in which this should be represented in the console
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction;
    }
}
