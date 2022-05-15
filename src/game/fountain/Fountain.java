package game.fountain;

import edu.monash.fit2099.engine.positions.Ground;

public abstract class Fountain extends Ground implements Fillwater{
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Fountain(char displayChar) {
        super(displayChar);
    }
}
