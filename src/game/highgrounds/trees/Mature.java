package game.highgrounds.trees;


import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Dirt;
import game.enemies.Koopa;

import java.util.List;
import java.util.Random;

/**
 * A class that represents the final stage of a tree.
 */
public class Mature extends Ground {

    public Mature() {
        super('T');
    }

    /**
     * Random number generator
     */
    Random rand = new Random();

    /**
     * Turns this mature tree has been growing (as a mature tree)
     */
    int turnsAlive;

    /**
     * Success chance (as a percentage) to jump onto this
     */
    int jumpSuccessChance = 70;
    /**
     * Damage taken by failing to jump onto this object
     */
    int jumpFailureDamage = 30;

    public int getJumpSuccessChance() {
        return jumpSuccessChance;
    }

    public int getJumpFailureDamage() {
        return jumpFailureDamage;
    }

    /**
     *
     * @param location The Mature tree object
     */
    @Override
    public void tick(Location location) {
        turnsAlive += 1;
        if (rand.nextInt(100) <= 20) { //20% chance per tick to die and turn to dirt
            location.setGround(new Dirt());
        }
        if (rand.nextInt(100) <= 10) { //10% chance per tick to spawn a koopa
            location.addActor(new Koopa());
            System.out.println("Koopa Spawned!");
        }
        if (turnsAlive % 5 == 0) { // will attempt to produce a sprout every 5 turns
            List<Exit> surroundingLocations = location.getExits();

            int surroundingDirt = 0; // calculate how many surrounding tiles are valid locations to grow a new sapling
            for (Exit exit : surroundingLocations) {
                if (exit.getDestination().getGround().getDisplayChar() == '.' ) {
                    surroundingDirt++;
                }
            }

            int newSproutTile = rand.nextInt(surroundingDirt); //pick a random surrounding dirt tile to grow a sprout

            int i = 0;
            for (Exit exit : surroundingLocations) {
                 /* loop until you reach the randomly picked dirt tile
                 if there is no actor on it, grow a sprout
                 if the space is occupied, it will have to wait another 5 turns to try again */
                if (exit.getDestination().getGround().getDisplayChar() == '.' && i == newSproutTile && !exit.getDestination().containsAnActor()) { // if this is the growth tile, grow a sprout
                    exit.getDestination().setGround(new Sprout());
                    break;
                }
                else{
                    i++;
                }
            }
        }
    }
}
