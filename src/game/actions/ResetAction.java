package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;


public class ResetAction extends Action {
    private static int useTime = 1;
    @Override
    public String execute(Actor actor, GameMap map) {
        //Trees have a 50% chance to be converted back to Dirt
        //All enemies are killed.
        //Reset player status (e.g., from Super Mushroom and Power Star)
        //Heal player to maximum This is done by yepu :)
        //Remove all coins on the ground (Super Mushrooms and Power Stars may stay).
        //The execution of this can only be done once
        if (useTime == 1){
            useTime -= 1;
            ResetManager.getInstance().run();
            return actor + " has reseted the game.";
        }
        return actor + " has already used this";

    }

    @Override
    public String menuDescription(Actor actor) {
        return "reset everything";
    }

    @Override
    public String hotkey() {
        return "r";
    }
}
