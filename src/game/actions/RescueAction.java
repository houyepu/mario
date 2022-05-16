package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class RescueAction extends Action {

    public RescueAction() {
        // Do Nothing
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        System.exit(0);
        return "Exit";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rescues Peach from her captivity!";
    }
}
