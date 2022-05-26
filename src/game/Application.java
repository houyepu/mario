package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.allies.PrincessPeach;
import game.consumables.FireFlower;
import game.enemies.Bowser;
import game.enemies.Koopa;
import game.fountain.Bottle;
import game.fountain.HealthFountain;
import game.fountain.PowerFountain;
import game.jumpablegrounds.Lava;
import game.jumpablegrounds.Wall;
import game.jumpablegrounds.WarpPipe;
import game.jumpablegrounds.trees.Mature;
import game.jumpablegrounds.trees.Sapling;
import game.jumpablegrounds.trees.Sprout;
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
				".........................................LLLL#########",
				".........................................LLLL#_______#",
				"..........................................LLL###_____#",
				"...........................................LLLL#_____#",
				"...........................................LLLL#_____#",
				"...........................................LLLL#_____#",
				"...........................................LLLL#_____#",
				"...........................................LLLL#_____#",
				"...........................................LLLL####_##",
				"............................................LLL#_____#",
				".............................................LL#_____#",
				"...............................................#_____#",
				"...............................................______#",
				"...............................................#######");

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
			gameMapLavaWorld.at(46, 1).addActor(new PrincessPeach());
			gameMapLavaWorld.at(51, 2).addActor(new Bowser());

			WarpPipeLadder warpPipe = new WarpPipeLadder();
			warpPipe.addSampleAction(new MoveActorAction(gameMapLavaWorld.at(2,2),"to the final lava map!"));

			WarpPipeLadder warpPipe2 = new WarpPipeLadder();
			warpPipe2.addSampleAction(new MoveActorAction(gameMapOverWorld.at(42,11),"back to the first map!"));

			gameMapLavaWorld.at(2,2).addItem(warpPipe2);
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
