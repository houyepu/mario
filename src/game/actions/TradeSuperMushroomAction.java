package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.consumables.SuperMushroom;

/**
 * Trade toad with a super mushroom
 */
public class TradeSuperMushroomAction extends Action{

    /**
     * toad
     */
    private final Actor toad;

    private int price = 400;

    /**
     * Constutoring a toad
     * @param toad
     */
    public TradeSuperMushroomAction(Actor toad) {
        this.toad = toad;
    }

    // Making a superMushroom to test trading
    SuperMushroom superMushroom = new SuperMushroom();

    /**
     * Trade with toad
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (Player.wallet < price){
            return "Not enough money to buy a super mushroom";
        }
        else {
            actor.addItemToInventory(superMushroom);
            Player.wallet -= price;
            System.out.println("now player has"+actor.getInventory());
            return "Thanks for purchasing super mushroom";
        }
    }

    /**
     * Description
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Mario buys Super Mushroom for ($400)";
    }
}
