// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package pacman.tiles;

import pacman.Game;
import pacman.events.PlayerMove.Direction;
import pacman.util.Position;

/**
 * Represents the player on the board. This includes, for example, any
 * information about the player (such as whether they have eaten a powerup
 * pill).
 *
 * @author David J. Pearce
 *
 */
public class Player implements Tile {
	private int powerupLeft = 0;

	public boolean powerUpActive() {
		System.out.println(powerupLeft > 0);
		return powerupLeft > 0;
	}

	@Override
	public String toString() {
		if (powerUpActive()) {
			return "O";
		}
		return "o";
	}

	@Override
	public boolean isObstruction() {
		return false;
	}

	public void move(Game game, Position pp, Direction direction) {
		powerupLeft--;
		// Calculate player's new position
		Position np = pp.moveWithin(direction, game.getWidth(), game.getHeight());
		Tile pt = game.getTile(np);

		// cannot move there
		if (pt.isObstruction()) {
			return;
		}
		if (pt instanceof Ghost) {
			if (powerUpActive()) {
				System.out.println("Eating Ghost");
				game.setTile(np, Air.AIR);
			} else {
				game.setTile(pp, Air.AIR);
				return;
			}
		}
		if (pt instanceof Dot) {
			game.setTile(np, Air.AIR);
		}
		if (pt instanceof Pill) {
			powerupLeft = 6;
			game.setTile(np, Air.AIR);
		}
		game.swapTile(pp, np);
	}
}
