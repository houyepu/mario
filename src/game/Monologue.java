package game;

import java.util.ArrayList;

public class Monologue {
    /**
     * Monologue is an arraylist
     */
    ArrayList<String> princessmonologue;
    ArrayList<String> toadmonologue;
    ArrayList<String> bowsermonologue;
    ArrayList<String> goombamonologue;
    ArrayList<String> koopamonologue;
    ArrayList<String> flyingkoopamonologue;
    ArrayList<String> pirahaplantsmonologue;

    public int selectRandomNum(int min, int max){
        // prints a random number between min and max value
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }
    public String princessmonologue(){
        princessmonologue.add("Dear Mario, I'll be waiting for you...");
        princessmonologue.add("Never gonna give you up!");
        princessmonologue.add("Release me, or I will kick you!");
        return princessmonologue.get(selectRandomNum(0, 2));
    }
    public String toadmonologue(){
        princessmonologue.add("You better get back to finding the Power Stars.");
        princessmonologue.add("The Princess is depending on you! You are our only hope.");
        princessmonologue.add("Being imprisoned in these walls can drive a fungus crazy :(");
        princessmonologue.add("You might need a wrench to smash Koopa's hard shells.");
        return princessmonologue.get(selectRandomNum(0, 3));
    }
    public String bowsermonologue(){
        toadmonologue.add("What was that sound? Oh, just a fire.");
        toadmonologue.add("Princess Peach! You are formally invited... to the creation of my new kingdom!");
        toadmonologue.add("Never gonna let you down!");
        toadmonologue.add("Wrrrrrrrrrrrrrrrryyyyyyyyyyyyyy!!!!");
        return toadmonologue.get(selectRandomNum(0, 3));
    }
    public String goombamonologue(){
        princessmonologue.add("Mugga mugga!");
        princessmonologue.add("Ugha ugha... (Never gonna run around and desert you...)");
        princessmonologue.add("Ooga-Chaka Ooga-Ooga!");
        return princessmonologue.get(selectRandomNum(0, 2));
    }
    public String koopamonologue(){
        princessmonologue.add("Never gonna make you cry!");
        princessmonologue.add("Koopi koopi koopii~!");
        return princessmonologue.get(selectRandomNum(0, 1));
    }
    public String flyingkoopamonologue(){
        princessmonologue.add("Slsstssthshs~! (Never gonna say goodbye~)");
        princessmonologue.add("Ohmnom nom nom nom.");
        return princessmonologue.get(selectRandomNum(0, 1));
    }

}
