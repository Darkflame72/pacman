// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package pacman.tiles;

/**
 * Represents a wall on the board which neither the player nor a ghost can pass
 * through.
 *
 * @author David J. Pearce
 *
 */
public class Wall implements Tile {
	@Override
	public String toString() {
		return "#";
	}

	@Override
	public boolean isObstruction() {
		return true;
	}
}
