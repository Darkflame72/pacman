// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package pacman.events;

import pacman.Game;
import pacman.tiles.*;
import pacman.util.Position;
import pacman.io.GameError;

/**
 * Represents a directional move of the player within a given input sequence.
 *
 * @author David J. Pearce
 *
 */
public class PlayerMove implements Event {
	/**
	 * Represents one of the four directions in which the pacman can move (Up, Down,
	 * Left and Right).
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	/**
	 * Indicates the direction in which the player should move.
	 */
	private final Direction direction;

	/**
	 * Construct a new player move object for a given direction.
	 *
	 * @param direction Indicates which direction the player is moving
	 */
	public PlayerMove(Direction direction) {
		this.direction = Direction.UP;
	}

	@Override
	public void apply(Game game) {
		// Find player's position on the board.
		Position pp = game.locatePlayer();
		// Get player object
		Player player = (Player) game.getTile(pp);
		// Move player in this direction
		player.move(game, pp, direction);
	}
}
