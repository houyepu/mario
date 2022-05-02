package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.Wrench;

// POSTPONDING WAITING FOR WRENCH TO BE CREATED

/**
 * Trade wrench with the toad
 */
public class TradeWrenchAction extends Action {
    /**
     * toad
     */
    private final Actor toad;

    /**
     * price for wrench
     */
    private int price = 200;

    //Making a new wrench
    Wrench wrench = new Wrench();

    /**
     * Constructing trade wrench
     *
     * @param toad
     */
    public TradeWrenchAction(Actor toad) {
        this.toad = toad;
    }

    /**
     * Trade with toad
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return "Thanks for purchasing wrench"
     */

    @Override
    public String execute(Actor actor, GameMap map) {
        //Check if wallet is less than the price
        if (Player.wallet < price) {
            return "Not enough money to buy a wrench";
        }
        //Add item to the inventory wallet minus the price
        else {
            actor.addItemToInventory(wrench);
            Player.wallet -= price;
            System.out.println("now player has" + actor.getInventory());
            return "Thanks for purchasing wrench";
        }
    }

    /**
     * Description
     *
     * @param actor The actor performing the action.
     * @return "Mario buys Wrench for ($200)"
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Mario buys Wrench for ($200)";
    }
}