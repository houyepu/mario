package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.highgrounds.HighGround;

public class Lava extends HighGround {
    private static int LAVA_DAMAGE = 15;

    int jumpSuccessChance = 100;
    int jumpFailureDamage = 0;
    public int getJumpSuccessChance() {
        return jumpSuccessChance;
    }

    public int getJumpFailureDamage() {
        return jumpFailureDamage;
    }

	public Lava() {
            super('L');
        }

    @Override
    public void tick(Location location) {
        super.tick(location);
        if (location.containsAnActor()) {
            location.getActor().hurt(LAVA_DAMAGE);
            System.out.println("The " + location.getActor() + " takes " + LAVA_DAMAGE + " points of damage from standing in lava.");
        }
    }
}

