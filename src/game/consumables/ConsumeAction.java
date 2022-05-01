package game.consumables;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;

public class ConsumeAction extends Action {

    protected ConsumableItem consumableItem;

    public ConsumeAction(ConsumableItem newConsumableItem) {
        this.consumableItem = newConsumableItem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (Player.player.getInventory().contains(consumableItem)) {
            consumableItem.consume();
            return "Player consumed " + consumableItem;
        }
        else {
            return "Player failed to consume the item";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumableItem;
    }
}
