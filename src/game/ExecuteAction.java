package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enemies.Koopa;

public class ExecuteAction extends Action {

    protected Actor target;
    protected String direction;

    public ExecuteAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " executes " + target + " at " + direction;
    }
}
