package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Toad is speaking to the player
 */
public class MonologueAction extends Action{
    /**
     * A frog boi
     */
    private final Actor toad;

    /**
     * Constructing a toad
     * @param toad
     */
    public MonologueAction(Actor toad) {
        this.toad = toad;
    }

    /**
     * Speak something
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return "Toad begins beatboxing.";
    }

    /**
     * Description
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Wanna hear something?";
    }
}
