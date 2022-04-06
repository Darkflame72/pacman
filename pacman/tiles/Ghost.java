package pacman.tiles;

import pacman.Game;
import pacman.events.PlayerMove.Direction;
import pacman.util.Position;

public class Ghost implements Tile {

    private Direction direction = Direction.RIGHT;

    public Ghost(Direction direction) {
        this.direction = direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        if (direction == Direction.RIGHT) {
            return ">";
        } else if (direction == Direction.LEFT) {
            return "<";
        } else if (direction == Direction.UP) {
            return "^";
        } else {
            return "v";
        }
    }

    @Override
    public boolean isObstruction() {
        return false;
    }

    public void move(Game game, Position pp) {

        // calculate ghost's new positio
        Position np = pp.moveWithin(direction, game.getWidth(), game.getHeight());

        Tile pt = game.getTile(np);

        game.swapTile(pp, np);
    }
}
