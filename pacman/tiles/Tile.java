// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package pacman.tiles;

/**
 * Represents an arbitrary piece on the board. This includes the player, as well
 * as walls, dots, ghosts, etc.
 *
 * @author David J. Pearce
 *
 */
public interface Tile {
	/**
	 * Check whether this tile is an obstruction which prevents the character from
	 * moving. For example, platforms prevent the character from moving.
	 *
	 * @return True if this tile does obstruct movement.
	 */
	public boolean isObstruction();
}
