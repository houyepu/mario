package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.consumables.PowerStar;


public class DropPowerStarAction extends DropItemAction {
    private final PowerStar powerStar;

    public DropPowerStarAction(PowerStar powerStar){
        super(powerStar);
        this.powerStar = powerStar;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return "Power star cannot be dropped";
    }
}
