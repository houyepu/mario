package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;


public class ResetAction extends Action {
    public static int useTime = 0;
    @Override
    public String execute(Actor actor, GameMap map) {
        //Trees have a 50% chance to be converted back to Dirt
        //All enemies are killed.
        //Reset player status (e.g., from Super Mushroom and Power Star)
        //Heal player to maximum This is done by yepu :)
        //Remove all coins on the ground (Super Mushrooms and Power Stars may stay).
        //The execution of this can only be done once
        ResetManager.getInstance().run(map);
        useTime++;
        return actor + " has reset the game.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Reset the game";
    }

    @Override
    public String hotkey() {
        return "r";
    }
}
