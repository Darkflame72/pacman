package pacman.tiles;

import java.util.ArrayList;

import pacman.Game;
import pacman.events.PlayerMove.Direction;
import pacman.util.Position;

/**
 * Represents a ghost on the board.
 *
 * @author Leon J. Bowie
 *
 */
public class Ghost implements Tile {

    /**
     * Current direction the ghost is travelling in.
     */
    private Direction direction;

    /**
     * If the ghost is currently on a dot.
     */
    private boolean onDot;

    /**
     * Construct a new ghost object for a given direction.
     *
     * @param direction Indicates which direction the ghost is moving
     */
    public Ghost(Direction direction) {
        this.direction = direction;
        this.onDot = false;
    }

    /**
     * Indicate if the ghost is currently on a dot.
     * 
     * @return true if the ghost is on a dot, false otherwise.
     */
    public boolean isOnDot() {
        return onDot;
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

    /**
     * Get the options to move to from the current direction.
     * 
     * @param game The game object.
     * @param pp   The position of the ghost.
     */
    private Position[] getOptions(Game game, Position pp) {
        Position[] positions = new Position[4];
        if (direction == Direction.UP) {
            positions[0] = pp.moveWithin(Direction.LEFT, game.getWidth(), game.getHeight());
            positions[1] = pp.moveWithin(Direction.UP, game.getWidth(), game.getHeight());
            positions[2] = pp.moveWithin(Direction.RIGHT, game.getWidth(), game.getHeight());
            positions[3] = pp.moveWithin(Direction.DOWN, game.getWidth(), game.getHeight());
        } else if (direction == Direction.RIGHT) {
            positions[0] = pp.moveWithin(Direction.UP, game.getWidth(), game.getHeight());
            positions[1] = pp.moveWithin(Direction.RIGHT, game.getWidth(), game.getHeight());
            positions[2] = pp.moveWithin(Direction.DOWN, game.getWidth(), game.getHeight());
            positions[3] = pp.moveWithin(Direction.LEFT, game.getWidth(), game.getHeight());
        } else if (direction == Direction.DOWN) {
            positions[0] = pp.moveWithin(Direction.RIGHT, game.getWidth(), game.getHeight());
            positions[1] = pp.moveWithin(Direction.DOWN, game.getWidth(), game.getHeight());
            positions[2] = pp.moveWithin(Direction.LEFT, game.getWidth(), game.getHeight());
            positions[3] = pp.moveWithin(Direction.UP, game.getWidth(), game.getHeight());
        } else {
            positions[0] = pp.moveWithin(Direction.DOWN, game.getWidth(), game.getHeight());
            positions[1] = pp.moveWithin(Direction.LEFT, game.getWidth(), game.getHeight());
            positions[2] = pp.moveWithin(Direction.UP, game.getWidth(), game.getHeight());
            positions[3] = pp.moveWithin(Direction.RIGHT, game.getWidth(), game.getHeight());
        }
        return positions;
    }

    /**
     * Update the current direction of the ghost based on the new position.
     * 
     * @param options The options the ghost had to move to.
     * @param np      The position the ghost has moved to.
     */
    public void updateDirection(Position[] options, Position np) {
        if (direction == Direction.UP) {
            if (options[0].equals(np)) {
                direction = Direction.LEFT;
            } else if (options[1].equals(np)) {
                direction = Direction.UP;
            } else if (options[2].equals(np)) {
                direction = Direction.RIGHT;
            } else {
                direction = Direction.DOWN;
            }
        } else if (direction == Direction.RIGHT) {
            if (options[0].equals(np)) {
                direction = Direction.UP;
            } else if (options[1].equals(np)) {
                direction = Direction.RIGHT;
            } else if (options[2].equals(np)) {
                direction = Direction.DOWN;
            } else {
                direction = Direction.LEFT;
            }
        } else if (direction == Direction.DOWN) {
            if (options[0].equals(np)) {
                direction = Direction.RIGHT;
            } else if (options[1].equals(np)) {
                direction = Direction.DOWN;
            } else if (options[2].equals(np)) {
                direction = Direction.LEFT;
            } else {
                direction = Direction.UP;
            }
        } else {
            if (options[0].equals(np)) {
                direction = Direction.DOWN;
            } else if (options[1].equals(np)) {
                direction = Direction.LEFT;
            } else if (options[2].equals(np)) {
                direction = Direction.UP;
            } else {
                direction = Direction.RIGHT;
            }
        }
    }

    /**
     * Move the ghost one position.
     * 
     * @param game The game object.
     * @param pp   The position of the ghost.
     */
    public void move(Game game, Position pp) {
        Position[] options = getOptions(game, pp);
        Tile[] tiles = { game.getTile(options[0]), game.getTile(options[1]), game.getTile(options[2]),
                game.getTile(options[3]) };
        Position np;

        // deal with dead end (one option)
        if (tiles[0].isObstruction() && tiles[1].isObstruction() && tiles[2].isObstruction()) {
            np = options[3];
        } else if (tiles[0].isObstruction() && tiles[1].isObstruction() && tiles[3].isObstruction()) {
            np = options[2];
        } else if (tiles[0].isObstruction() && tiles[2].isObstruction() && tiles[3].isObstruction()) {
            np = options[1];
        } else if (tiles[1].isObstruction() && tiles[2].isObstruction() && tiles[3].isObstruction()) {
            np = options[0];
        }

        // deal with two options
        else if (tiles[0].isObstruction() && tiles[1].isObstruction()) {
            np = options[2];
        } else if (tiles[0].isObstruction() && tiles[2].isObstruction()) {
            np = options[1];
        } else if (tiles[1].isObstruction() && tiles[2].isObstruction()) {
            np = options[0];
        }

        // deal with 3 options
        else {
            np = intersection(game, pp);
        }

        // deal with player collision
        if (game.getTile(np) instanceof Player) {
            Player player = (Player) game.getTile(game.locatePlayer());
            boolean frightened = player.powerUpActive();
            if (frightened) {
                // kill itself
                game.setTile(pp, Air.AIR);
                return;
            }
            game.setTile(np, Air.AIR);
        }

        Tile pt = game.getTile(np);
        // if the ghost is on a dot, this is updated at the end to preserve current
        // state of it has a dot.
        boolean updateOnDot = false;

        if (pt instanceof Dot) {
            game.setTile(np, Air.AIR);
            updateOnDot = true;
        }
        updateDirection(options, np);
        game.swapTile(pp, np);

        // if the ghost was on a dot place it back.
        if (onDot) {
            game.setTile(pp, new Dot());
            onDot = false;
        }
        // update the on dot state
        if (updateOnDot) {
            onDot = true;
        }
    }

    /**
     * Get the best position to move to at an intersection.
     * 
     * @param game the game
     * @param pp   the position of the ghost
     * @return the best position to move to
     */
    private Position intersection(Game game, Position pp) {
        ArrayList<Option> options = new ArrayList<Option>();
        Direction[] directions = { Direction.UP, Direction.LEFT, Direction.DOWN, Direction.RIGHT };

        // Get all the valid options of positions to move to.
        for (Direction d : directions) {
            Position np = pp.moveWithin(d, game.getWidth(), game.getHeight());
            double npDistance = game.distanceToPlayer(np);
            if (!game.getTile(np).isObstruction()) {
                options.add(new Option(np, npDistance));
            }
        }

        Player player = (Player) game.getTile(game.locatePlayer());
        boolean frightened = player.powerUpActive();

        return getIntersectionMove(options, frightened);
    }

    /**
     * Get the best move at an intersection from the available positions.
     * 
     * @param options    The available positions that can be moved to.
     * @param frightened If the ghost is currently frightened.
     * 
     * @return The best position to move to.
     */
    private Position getIntersectionMove(ArrayList<Option> options, boolean frightened) {
        double target;
        if (frightened) {
            // get furthest away
            target = Double.MIN_VALUE;
            for (Option o : options) {
                if (o.getDistance() > target) {
                    target = o.getDistance();
                }
            }
        } else {
            // get closest
            target = Double.MAX_VALUE;
            for (Option o : options) {
                if (o.getDistance() < target) {
                    target = o.getDistance();
                }
            }
        }

        // get first option with target distance
        for (Option o : options) {
            if (o.getDistance() == target) {
                return o.getPosition();
            }
        }

        return null;
    }
}

/**
 * This class represents an option for the ghost to move to.
 */
class Option {

    /**
     * The position of the option.
     */
    private Position position;

    /**
     * The distance of the option to the player.
     */
    private double distance;

    /**
     * Construct a option object for a ghost position.
     *
     * @param position The position of the option.
     * @param distance The distance of the option to the player.
     */
    public Option(Position position, double distance) {
        this.position = position;
        this.distance = distance;
    }

    /**
     * Get the position of the option.
     * 
     * @return The position of the option.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Get the distance of the option to the player.
     * 
     * @return The distance of the option to the player.
     */
    public double getDistance() {
        return distance;
    }
}
