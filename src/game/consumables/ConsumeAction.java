package game.consumables;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;

/**
 * A special action allowing consumption of items
 */
public class ConsumeAction extends Action {

    protected ConsumableItem consumableItem;

    public ConsumeAction(ConsumableItem newConsumableItem) {
        this.consumableItem = newConsumableItem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (Player.getInstance().getInventory().contains(consumableItem)) {
            consumableItem.consume();
            return "Player consumed " + consumableItem;
        }
        else {
            return "Please pick up item before consumption";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumableItem;
    }
}
