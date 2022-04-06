package pacman.tiles;

/**
 * Represents a powerup pill on the board.
 *
 * @author Leon J. Bowie
 *
 */
public class Pill implements Tile {

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public boolean isObstruction() {
        return false;
    }

}
