package game.fountain;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.Status;
import game.consumables.ConsumableItem;

public class HealthWater extends Water{


    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public HealthWater() {
        super("HealthWater",'H',true);
    }
    @Override
    public void consume() {
        super.consume();
        Player.getInstance().heal(50); // Heal the player by 200 points
        System.out.println("Mario has drank health water"); // Print out "MARIO IS INVINCIBLE" to console
    }
}
