package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.fountain.Bottle;

public class FillHealthWaterAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        Bottle.bottle.push("HealthWater");
        System.out.println(actor.getInventory());
        System.out.println(Bottle.bottle);
        return "Mario has refilled his water";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " refills bottle from health fountain";
    }



}
