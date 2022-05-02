package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;

/**
 * Special action used to destroy a Koopa's shell
 */
public class ExecuteAction extends Action {

    /**
     * The Actor that should be targeted for execution
     */
    protected Actor target;

    /**
     * The direction of the action
     */
    protected String direction;

    public ExecuteAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Used to execute the Koopa; breaks their shell (removes them) and drops a SuperMushroom
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return    A string to show success/failure
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result;

        if (!target.isConscious() && target.hasCapability(Status.DORMANT) && actor.getWeapon().verb().equals("wrenches")){
            ActionList dropActions = new ActionList();
            // drop all items
            for (Item item : target.getInventory())
                dropActions.add(item.getDropAction(actor));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
            result = target + " is executed.";
        }
        else {
            result = target + " cannot be executed at the moment.";
        }

        return result;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return      A string to be displayed in the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " executes " + target + " at " + direction;
    }
}
