package game.enemies;

import game.Status;

public class FlyingKoopa extends Koopa {
    public FlyingKoopa() {
        super();
        this.addCapability(Status.FLYING);
        this.setDisplayChar('F');
        this.resetMaxHp(150);
    }
}
