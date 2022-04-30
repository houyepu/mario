package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class TradeWithToadAction extends Action{
    private final Actor toad;

    public TradeWithToadAction(Actor toad) {
        this.toad = toad;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Wanna trade with me?";
    }
}
