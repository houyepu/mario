package game.fountain;

import game.Player;

public class PowerFountain extends Fountain {
    private Water powerwater;
    /**
     * Constructor.
     *
     */
    public PowerFountain() {
        super('A');
        this.powerwater = powerwater;
    }

    public void fill(){
        Player.Bottle.push(powerwater);
    }
}
