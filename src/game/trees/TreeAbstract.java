package game.trees;

import edu.monash.fit2099.engine.positions.Ground;

public abstract class TreeAbstract extends Ground {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public TreeAbstract(char displayChar) {
        super(displayChar);
    }
}
