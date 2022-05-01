package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import game.Player;
import game.Status;
import game.actions.DropPowerStarAction;
import game.actions.DropSuperMushroomAction;

public class SuperMushroom extends ConsumableItem{
    public SuperMushroom() {
        super("Super Mushroom", '^', true);
    }

    @Override
    public void consume() {
        super.consume();
        Player.player.increaseMaxHp(50);
        Player.player.addCapability(Status.TALL);
    }
}
