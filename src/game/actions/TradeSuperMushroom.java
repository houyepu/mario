package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.consumables.PowerStar;
import game.consumables.SuperMushroom;

/**
 * Trade toad with a super mushroom
 */
public class TradeSuperMushroom extends Action{

    /**
     * toad
     */
    private final Actor toad;

    /**
     *  price of the super mushroom
     */
    private int price = 400;

    // Adding a superMushroom
    SuperMushroom superMushroom = new SuperMushroom();

    /**
     * Constructor Super mushroom
     * @param toad
     */
    public TradeSuperMushroom(Actor toad) {
        this.toad = toad;
    }

    /**
     * Trade with toad
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return "Thanks for purchasing super mushroom"
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        //Check if wallet is less than the price
        if (Player.wallet < price){
            return "Not enough money to buy a super mushroom";
        }
        //Add item to the inventory wallet minus the price
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
     * @return "Mario buys Super Mushroom for ($400)"
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Mario buys Super Mushroom for ($400)";
    }
}
