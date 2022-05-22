package game.jumpablegrounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Goomba;

import java.util.Random;

/**
 * A class that represents the first stage of a tree.
 */
public class Sprout extends Tree {

    /**
     * Random number generator
     */
    private final Random rand = new Random();

    /**
     * Success chance (as a percentage) to jump onto this
     */
    int jumpSuccessChance = 90;

    /**
     * Damage taken by failing to jump onto this object
     */
    int jumpFailureDamage = 10;

    /**
     * Turns this sprout has been growing (as a sprout)
     */
    int turnsAlive;

    public int getJumpSuccessChance() {
        return jumpSuccessChance;
    }

    public int getJumpFailureDamage() {
        return jumpFailureDamage;
    }


    /**
     * Constructor
     *
     * @see edu.monash.fit2099.engine.positions.Ground
     */
    public Sprout() {
        super('+');
        turnsAlive = 0;
    }


    @Override
    public void tick(Location location) {
        turnsAlive += 1;
        if (turnsAlive >= 9) { //after 10 turns, time to move to the next stage
            System.out.println("SPROUTS GROW UP"); //testing purposes only
            location.setGround(new Sapling());
        }
        if (rand.nextInt(100) <= 10) {
            if (!location.containsAnActor()) {
                location.addActor(new Goomba());
                System.out.println("Goomba spawned");
            }
        }

    }


}
