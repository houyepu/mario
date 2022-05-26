package game.enemies;

import game.Status;

/**
 * A Koopa that can fly
 */
public class FlyingKoopa extends Koopa {
    /**
     * Constructor.
     */
    public FlyingKoopa() {
        super(); // Super constructor
        this.addCapability(Status.FLYING); // Set this Koopa to have the ability to fly
        this.setDisplayChar('F'); // Change its displayChar to 'F' to represent flying status
        this.resetMaxHp(150); // Set its HP to be 150
    }
}
