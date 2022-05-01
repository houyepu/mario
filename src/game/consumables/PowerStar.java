package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import game.actions.DropPowerStarAction;

public class PowerStar extends ConsumableItem{
    public PowerStar() {
        super("Power Star", '*', true);
    }

    @Override
    public void consume() {
        super.consume();

    }

    //replace the normal drop item action
    @Override
    public DropItemAction getDropAction(Actor actor) { return new DropPowerStarAction(this);}
}
