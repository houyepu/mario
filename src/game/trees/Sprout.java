package game.trees;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Sprout extends TreeAbstract {
    Random rand = new Random();


    public Sprout() {
        super('+');
        turnsAlive = 0;
    }

    int turnsAlive;

    @Override
    public void tick(Location location) {
        turnsAlive += 1;
        if (turnsAlive >= 9) { //after 10 turns, time to move to the next stage
            System.out.println("SPROUTS GROW UP"); //testing purposes only
            location.setGround(new Sapling());
        }
    }
}
