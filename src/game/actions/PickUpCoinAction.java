package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.wallet.Coin;

/**
 * A class designed specifically for picking up coin
 */
public class PickUpCoinAction extends PickUpItemAction {
    /**
     * Coin attribute
     */
    private final Coin coin;

    /**
     * New pick up action specifically for picking up coin
     * @param coin
     */
    public PickUpCoinAction(Coin coin) {
        super(coin);
        this.coin = coin;
    }

    /**
     * Override exisiting method of execute
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        coin.togglePortability();
        map.locationOf(actor).removeItem(coin);
        actor.addItemToInventory(coin);
        Player.wallet += coin.getValue();
        System.out.println("Player now has:$"+Player.wallet);
        return menuDescription(actor);
    }
}
