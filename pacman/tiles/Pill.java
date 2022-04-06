package pacman.tiles;

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
