package game.highgrounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
// will this be a ground ???????? or a weapon
public class Fire extends Ground {
    private int fireTurnsRemaining;
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Fire(char displayChar) {
        super('v');
        this.fireTurnsRemaining = 3;
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        fireTurnsRemaining--; // Make the PowerStar a step closer to fading away
        System.out.println("Fire flower has " + fireTurnsRemaining + " turns remaining"); // Print the turns remaining
        if (fireTurnsRemaining <= 0){

        }

    }
}
