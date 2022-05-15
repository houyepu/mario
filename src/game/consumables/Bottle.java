package game.consumables;

import game.fountain.Water;

import java.util.Stack;

public class Bottle extends ConsumableItem{

    public Bottle(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        Stack<Water> bottle = new Stack<Water>();
    }
}
