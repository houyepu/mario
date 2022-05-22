package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.demo.mars.items.MartianItem;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.actions.TeleportAction;
import game.allies.PrincessPeach;
import game.consumables.FireFlower;
import game.consumables.PowerStar;
import game.consumables.SuperMushroom;
import game.enemies.Bowser;
import game.enemies.Koopa;
import game.enemies.PiranhaPlant;
import game.fountain.Bottle;
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

			List<String> mapOverWorld = Arrays.asList(
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

		List<String> mapLavaWorld = Arrays.asList(
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				".....................................L..........................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				"................................................................................");


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


			GameMap gameMapOverWorld;
			GameMap gameMapLavaWorld;
			gameMapOverWorld = new GameMap(groundFactory, mapOverWorld);
			gameMapLavaWorld = new GameMap(groundFactory, mapLavaWorld);
			world.addGameMap(gameMapOverWorld);
			world.addGameMap(gameMapLavaWorld);

			Location lavaTeleportLocation = gameMapLavaWorld.at(1,1);


			Actor mario = Player.getInstance();

			gameMapOverWorld.at(42,9).addItem(new Fire());
			gameMapOverWorld.at(42, 11).addItem(new FireFlower());
			world.addPlayer(mario, gameMapOverWorld.at(42, 10));
			gameMapOverWorld.at(43, 10).addActor(new PrincessPeach());
			gameMapOverWorld.at(45, 10).addActor(new Bowser());


			/*MartianItem rocket = new MartianItem("Rocket", '^', false);
			rocket.addSampleAction(new MoveActorAction(mars.at(7, 2), "to Mars!"));
			gameMap.at(1, 1).addItem(rocket);*/

			WarpPipeLadder warpPipe = new WarpPipeLadder();
			warpPipe.addSampleAction(new MoveActorAction(gameMapLavaWorld.at(2,2),"teleportation TIME!!"));
			gameMapOverWorld.at(42,11).addItem(warpPipe);




			//gameMap.at(34, 10).addActor(new Goomba());
			gameMapOverWorld.at(35, 10).addActor(new Koopa());

			//gameMap.at(35, 10).addActor(new Goomba());

			// Toad
			//gameMap.at(45,10).addActor(new Toad());

			// Testing out the coin
			Coin coin = new Coin("coin",'$',true,20);

			gameMapOverWorld.at(42,11).setGround(new HealthFountain());
			gameMapOverWorld.at(42,12).setGround(new PowerFountain());
			gameMapOverWorld.at(42,13).addItem(new FireFlower());
			mario.addItemToInventory(new Bottle());

			// Test for wrench
			/*gameMap.at(42,7).addItem(new Wrench());
			gameMap.at(42,8).addItem(new SuperMushroom());
			gameMap.at(42,9).addItem(new PowerStar());
			gameMap.at(44,9).addItem(new Kea
			y());*/

			world.run();
	}
}
