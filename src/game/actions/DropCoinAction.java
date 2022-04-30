package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.wallet.Coin;

public class DropCoinAction extends DropItemAction {
    private final Coin coin;

    public DropCoinAction(Coin coin){
        super(coin);
        this.coin = coin;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return "Coins cannot be dropped";
    }
}
