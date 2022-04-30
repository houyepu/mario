package game.trees;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Goomba;
import game.wallet.Coin;

import java.util.Random;

public class Sapling extends Ground {

    public Sapling() {
        super('t');
    }

    Random rand = new Random();
    int turnsAlive;

    @Override
    public void tick(Location location) {
        turnsAlive += 1;
        if (turnsAlive >= 9) { //after 10 turns, time to move to the next stage
            System.out.println("SAPLINGS GROW UP"); //testing purposes only
            location.setGround(new Mature());
        }
        if (rand.nextInt(100) <= 10) {
            location.addItem(new Coin("coin",'$',true,20));
            System.out.println("Money tree!");
        }

    }
}
