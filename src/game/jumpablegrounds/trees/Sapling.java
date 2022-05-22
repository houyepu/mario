package game.jumpablegrounds.trees;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.wallet.Coin;

import java.util.Random;

/**
 * A class that represents the second stage of a tree.
 */
public class Sapling extends Ground {

    public Sapling() {
        super('t');
    }

    /**
     * Random number generator
     */
    Random rand = new Random();

    /**
     * Turns this sapling has been growing (as a sapling)
     */
    int turnsAlive;

    /**
     * Success chance (as a percentage) to jump onto this
     */
    int jumpSuccessChance = 80;
    /**
     * Damage taken by failing to jump onto this object
     */
    int jumpFailureDamage = 20;

    public int getJumpSuccessChance() {
        return jumpSuccessChance;
    }

    public int getJumpFailureDamage() {
        return jumpFailureDamage;
    }

    @Override
    public void tick(Location location) {
        turnsAlive += 1;
        if (turnsAlive >= 9) { //after 10 turns, time to move to the next stage
            System.out.println("SAPLINGS GROW UP"); //testing purposes only
            location.setGround(new Mature());
        }
        if (rand.nextInt(100) <= 10) {
            location.addItem(new Coin("coin", '$', true, 20));
            System.out.println("Money tree!");
        }
    }
}
