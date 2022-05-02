package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;

/**
 * Reset action
 */
public class ResetAction extends Action {
    /**
     * use time to account for the number of uses this reset action has been used
     */
    public static int useTime = 0;

    /**
     * Resets every resettable
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string indicating it has been resetted
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run(map);
        useTime++;
        return actor + " has reset the game.";
    }

    /**
     * Overriding description
     * @param actor The actor performing the action.
     * @return "Reset the game"
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Reset the game";
    }

    /**
     * Change of hotkey
     * @return "r"
     */
    @Override
    public String hotkey() {
        return "r";
    }
}
