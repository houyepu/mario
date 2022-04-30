package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Trade with toad action
 */
public class TradeSuperMushroom extends Action{
    /**
     * toad
     */
    private final Actor toad;

    /**
     * Constutoring a toad
     * @param toad
     */
    public TradeSuperMushroom(Actor toad) {
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
        return "Mario buys Super Mushroom for ($400)";
    }
}
