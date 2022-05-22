package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
// will this be a ground ???????? or a weapon
public class Fire extends Item {
    private int fireTurnsRemaining;
    private int fireBurnDamageAmount = 20;

    public Fire() {
        super("Fire",'v',false);
        this.fireTurnsRemaining = 3;
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        fireTurnsRemaining--; // Make the PowerStar a step closer to fading away

        if (location.containsAnActor()) {
            Actor burningActor = location.getActor();
            burningActor.hurt(fireBurnDamageAmount);
            System.out.println(burningActor + " takes " + fireBurnDamageAmount + " points of damage from starting their turn in a fire.");
        }

        if (fireTurnsRemaining <= 0){
            location.removeItem(this);
            System.out.println("A fire has been extinguished.");
        }
        else {
            System.out.println("A fire has " + fireTurnsRemaining + " turns before it is extinguished"); // Print the turns remaining
        }
    }
}
