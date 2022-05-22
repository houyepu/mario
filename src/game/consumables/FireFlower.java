package game.consumables;

import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.Status;

public class FireFlower extends ConsumableItem{
    private int fireFlowerTurnsRemaining;
    public FireFlower() {
        super("Fire Flower", 'f', true);
        this.fireFlowerTurnsRemaining = 10;
    }
    /**
     * Consume the power mushroom -> power up effects
     */
    @Override
    public void consume() {
        Player.playerPunchDamage = 20; // The player increase damage
        Player.getInstance().addCapability(Status.FIREATTACK); // The player now is going to reap the benefits of this item
        System.out.println("MARIO HAS FIRE ATTACK"); // Print out "MARIO IS INVINCIBLE" to console
    }
    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        fireFlowerTurnsRemaining--; // Make the PowerStar a step closer to fading away
        System.out.println("Fire flower has " + fireFlowerTurnsRemaining + " turns remaining"); // Print the turns remaining
        if (fireFlowerTurnsRemaining <= 0)
            currentLocation.removeItem(this); // Remove this item from the location if no turns remaining
    }
}
