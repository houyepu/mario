package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.Status;

public class FireFlower extends ConsumableItem{
    private int fireFlowerTurnsRemaining;
    public FireFlower() {
        super("Fire Flower", 'f', true);
        this.fireFlowerTurnsRemaining = 20;
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
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        // Same as above except for the actor's inventory
        fireFlowerTurnsRemaining--;
        System.out.println("Fire flower has " + fireFlowerTurnsRemaining + " turns remaining");
        if (fireFlowerTurnsRemaining <= 0){
            Player.getInstance().removeCapability(Status.FIREATTACK); // remove status after 20 turns
            System.out.println("Player has lost fire attack effect");
        }
    }
}
