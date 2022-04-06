// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package pacman.tiles;

/**
 * Represents empty space on the board. A specific singleton object is used for
 * this, rather than using <code>null</code>.
 *
 * @author David J. Pearce
 *
 */
public class Air implements Tile {

	public final static Air AIR = new Air();

	private Air() {
		// Constructor is private to ensure that the AIR constant is always used.
	}

	@Override
	public String toString() {
		return " ";
	}

	@Override
	public boolean isObstruction() {
		return false;
	}
}
