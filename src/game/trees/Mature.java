package game.trees;


import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Dirt;
import game.enemies.Koopa;
import game.wallet.Coin;

import java.util.List;
import java.util.Random;

public class Mature extends Ground {

    public Mature() {
        super('T');
    }

    Random rand = new Random();
    int turnsAlive;

    @Override
    public void tick(Location location) {
        turnsAlive += 1;
        if (rand.nextInt(100) <= 20) {
            System.out.println("A MATURE TREE HAS DIED"); //testing purposes only
            location.setGround(new Dirt());
        }
        /*if (rand.nextInt(100) <= 10) {
            location.addActor(new Koopa());
            System.out.println("Koopa Spawned!");
        }*/
        if (turnsAlive % 5 == 0) { // produce sprout every 5 turns
            List<Exit> surroundingLocations = location.getExits();
            int surroundingDirt = 0;
            for (Exit exit : surroundingLocations) { //calculate total surrounding dirt tiles
                if (exit.getDestination().getGround().getDisplayChar() == '.' ) {
                    surroundingDirt++;
                }
            }

            int newSproutTile = rand.nextInt(surroundingDirt); //pick a random surrounding dirt tile to grow a sprout
            int i = 0;
            for (Exit exit : surroundingLocations) { //loop until you reach the randomly picked dirt tile, then grow a sprout there

                if (exit.getDestination().getGround().getDisplayChar() == '.' && i == newSproutTile) { // if this is the growth tile, grow a sprout
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
