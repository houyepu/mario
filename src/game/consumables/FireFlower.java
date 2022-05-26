package game.consumables;

import game.Player;
import game.Status;

public class FireFlower extends ConsumableItem{
    private int fireFlowerTurnsRemaining;
    public FireFlower() {
        super("Fire Flower", 'f', true);
        this.fireFlowerTurnsRemaining = 20;
    }

    @Override
    public void consume() {
        super.consume();
        Player.getInstance().addCapability(Status.FIREPOWERED); // The player now is going to reap the benefits of this item
        System.out.println("MARIO HAS FIRE ATTACK"); // P
        Player.fireFlowerTurnsRemaining = 3;

    }
}
