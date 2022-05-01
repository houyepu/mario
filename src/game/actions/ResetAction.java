package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ResetAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        //Trees have a 50% chance to be converted back to Dirt

        //All enemies are killed.

        //Reset player status (e.g., from Super Mushroom and Power Star)

        //Heal player to maximum

        //Remove all coins on the ground (Super Mushrooms and Power Stars may stay).


        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Dokio Toma le";
    };

    @Override
    public String hotkey() {
        return "r";
    }
}
