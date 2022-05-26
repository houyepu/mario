package game.jumpablegrounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.Status;

/**
 * Class representing a wall
 */
public class Wall extends JumpableGround {

    /**
     * Constructor
     *
     * @see edu.monash.fit2099.engine.positions.Ground
     */
    public Wall() {
        super('#');
    }

    /**
     * Success chance (as a percentage) to jump onto this
     */
    public int jumpSuccessChance = 80;
    /**
     * Damage taken by failing to jump onto this object
     */
    public int jumpFailureDamage = 20;

    public int getJumpSuccessChance() {
        return jumpSuccessChance;
    }

    public int getJumpFailureDamage() {
        return jumpFailureDamage;
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
