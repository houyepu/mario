package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.consumables.PowerStar;

/**
 * Trade with toad action
 */
public class TradePowerStarAction extends Action {

    /**
     * A toad
     */
    private final Actor toad;

    /**
     * Price for power star
     */
    private int price = 600;

    // Adding a powerStar
    PowerStar powerStar = new PowerStar();

    /**
     * Constructor a trading for power star
     *
     * @param toad
     */
    public TradePowerStarAction(Actor toad) {
        this.toad = toad;
        this.price = price;
    }

    /**
     * Trade with toad for power star
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return "Thanks for purchasing power star"
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        //Check if wallet is less than the price
        if (Player.wallet < price) {
            return "Not enough money to buy a power star";
        }
        //Add to the inventory wallet minus the price
        else {
            actor.addItemToInventory(powerStar);
            Player.wallet -= price;
            System.out.println("now player has" + actor.getInventory());
            return "Thanks for purchasing power star";
        }
    }

    /**
     * Description
     *
     * @param actor The actor performing the action.
     * @return "Mario buys Power Star for ($600)"
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Mario buys Power Star for ($600)";
    }
}
