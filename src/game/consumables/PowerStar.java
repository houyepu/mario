package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import game.Player;
import game.actions.DropPowerStarAction;

public class PowerStar extends ConsumableItem{

    private int powerStarTurnsRemaining;

    public PowerStar() {
        super("Power Star", '*', true);
    }

    @Override
    public void consume() {
        super.consume();
        Player.player.increaseMaxHp(200);
    }
}
