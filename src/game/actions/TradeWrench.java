package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
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


    /**
     * Trade with toad
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
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