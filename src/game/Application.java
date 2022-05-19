package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.consumables.PowerStar;
import game.consumables.SuperMushroom;
import game.enemies.Koopa;
import game.fountain.HealthFountain;
import game.fountain.PowerFountain;
import game.highgrounds.Wall;
import game.highgrounds.WarpPipe;
import game.toad.Toad;
import game.highgrounds.trees.Mature;
import game.highgrounds.trees.Sapling;
import game.highgrounds.trees.Sprout;
import game.wallet.Coin;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) {

			World world = new World(new Display());

			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Mature(), new Sapling(), new Sprout(), new Lava(), new WarpPipe(), new HealthFountain(), new PowerFountain());

			List<String> map = Arrays.asList(
				"..........................................##....................................",
				"............+...............................#...................................",
				"............................................#...................................",
				".............................................##.................................",
				"...............................................#................................",
				"................................................#...............................",
				".................+................................#.............................",
				".................................................##.............................",
				"............................................Lc..##..............................",
				".........+..............................+#____####..............................",
				".......................................+#_____###...............................",
				".......................................+#______###..............................",
				"........................................+#_____###..............................",
				"........................+..................H.....##.............................",
				"...................................................#............................",
				"....................................................#...........................",
				"...................+.......................A.........#..........................",
				"......................................................#.........................",
				".......................................................##.......................");
/*
			//populate the map with random sprouts
			int sproutSpawnChance = 1; //per tile
			for (String i : map){
				String[] rows = i.split("");
				i = rows[0].replace('.','+');
				map.set(0,"..+.......................................##....................................");
				//System.out.println(i);
			}*/
		/*
		Able to get the first string in map, aka the first row of options and convert
		dirt tiles into sprouts, but I can't get that modified string into the original
		map list and then move on to the next string aka row 2.
		 */


			GameMap gameMap = new GameMap(groundFactory, map);
			world.addGameMap(gameMap);

			Actor mario = Player.getInstance();

			world.addPlayer(mario, gameMap.at(42, 10));


			//gameMap.at(34, 10).addActor(new Goomba());
			gameMap.at(35, 10).addActor(new Koopa());

			//gameMap.at(35, 10).addActor(new Goomba());

			// Toad
			gameMap.at(45,10).addActor(new Toad());

			// Testing out the coin
			Coin coin = new Coin("coin",'$',true,20);
			gameMap.at(42,11).addItem(coin);

			gameMap.at(42,12).addItem(coin);

			gameMap.at(43,10).setGround(new HealthFountain());
			// Test for wrench
			gameMap.at(42,7).addItem(new Wrench());
			gameMap.at(42,8).addItem(new SuperMushroom());
			gameMap.at(42,9).addItem(new PowerStar());

			world.run();
	}
}
