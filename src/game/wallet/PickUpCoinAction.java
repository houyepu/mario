package game.wallet;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;

public class PickUpCoinAction extends PickUpItemAction {
    private final Coin coin;
    private int Value;
    private Player player;

    public PickUpCoinAction(Coin coin) {
        super(coin);
        this.coin = coin;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).removeItem(coin);
        actor.addItemToInventory(coin);
        Value +=player.getWallet() + coin.getValue();
        player.setWallet(Value);
        return menuDescription(actor);
    }
}
