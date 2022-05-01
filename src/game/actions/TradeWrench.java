package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.Wrench;
import game.consumables.SuperMushroom;

// POSTPONDING WAITING FOR WRENCH TO BE CREATED
/**
 * Trade wrench with the toad
 */
public class TradeWrench extends Action{
    /**
     * toad
     */
    private final Actor toad;

    private int price = 200;
    /**
     * Constutoring a toad
     * @param toad
     */
    public TradeWrench(Actor toad) {
        this.toad = toad;
    }


    //making wrench for testing
    Wrench wrench = new Wrench();
    /**
     * Trade with toad
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (Player.wallet < price){
            return "Not enough money to buy a wrench";
        }
        else {
            actor.addItemToInventory(wrench);
            Player.wallet -= price;
            System.out.println("now player has"+actor.getInventory());
            return "Thanks for purchasing wrench";
        }
    }

    /**
     * Description
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Mario buys Wrench for ($200)";
    }
}