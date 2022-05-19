package game.fountain;

import game.Player;

public class HealthFountain extends Fountain implements Fillwater{
    private Water healthwater;
    /**
     * Constructor.
     *
     */
    public HealthFountain() {
        super('H');
        this.healthwater = healthwater;
    }
    public void fill(){
        Player.Bottle.push(healthwater);
    }
}
