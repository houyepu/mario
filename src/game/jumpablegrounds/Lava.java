package game.jumpablegrounds;

import edu.monash.fit2099.engine.positions.Location;

public class Lava extends JumpableGround {
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
            System.out.println(location.getActor() + " takes " + LAVA_DAMAGE + " points of damage from standing in lava.");
        }
    }
}

