package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.consumables.PowerStar;

/**
 * Trade with toad action
 */
public class TradePowerStar extends Action{

    /**
     * A toad
     */
    private final Actor toad;

    /**
     * Price for power star
     */
    private int price = 600;

    /**
     * Constutoring a trading for power star
     * @param toad
     */
    public TradePowerStar(Actor toad) {
        this.toad = toad;
        this.price = price;
    }

    // Making a powerstar to test trading
    PowerStar powerStar = new PowerStar("powerstar",'*',true);

    /**
     * Trade with toad for power star
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (Player.wallet < price){
            return "Not enough money to buy a power star";
        }
        else {
            actor.addItemToInventory(powerStar);
            Player.wallet -= price;
            System.out.println("now player has"+actor.getInventory());
            return "Thanks for purchasing power star";
        }
    }

    /**
     * Description
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Mario buys Power Star for ($600)";
    }
}
