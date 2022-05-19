package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.consumables.ConsumableItem;
import game.fountain.Water;

public class FillwaterAction extends Action {
    private Water water;

    @Override
    public String execute(Actor actor, GameMap map) {
        water.fill();
        System.out.println(Player.Bottle);
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " refills bottle from fountain";
    }



}
