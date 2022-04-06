package pacman.tiles;

import java.util.ArrayList;
import java.util.HashMap;

import pacman.Game;
import pacman.events.PlayerMove.Direction;
import pacman.util.Position;

public class Ghost implements Tile {

    private Direction direction = Direction.RIGHT;
    private boolean onDot = false;

    public Ghost(Direction direction) {
        this.direction = direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

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

    public void move(Game game, Position pp) {

        Position[] options = getOptions(game, pp);
        Tile[] tiles = new Tile[4];
        tiles[0] = game.getTile(options[0]);
        tiles[1] = game.getTile(options[1]);
        tiles[2] = game.getTile(options[2]);
        tiles[3] = game.getTile(options[3]);
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
        boolean updateOnDot = false;
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
        if (pt instanceof Dot) {
            game.setTile(np, Air.AIR);
            updateOnDot = true;
        }
        updateDirection(options, np);
        game.swapTile(pp, np);
        if (onDot) {
            game.setTile(pp, new Dot());
            onDot = false;
        }
        if (updateOnDot) {
            onDot = true;
        }
    }

    private Position intersection(Game game, Position pp) {
        System.out.println("Intersection");
        Player player = (Player) game.getTile(game.locatePlayer());
        boolean frightened = player.powerUpActive();

        ArrayList<Option> newOptions = new ArrayList<Option>();
        Position upPosition = pp.moveWithin(Direction.UP, game.getWidth(), game.getHeight());
        Tile upTile = game.getTile(upPosition);
        double upDistance = game.distanceToPlayer(upPosition);
        if (!upTile.isObstruction()) {
            newOptions.add(new Option(upPosition, upDistance, Direction.UP));
        }

        Position leftPosition = pp.moveWithin(Direction.LEFT, game.getWidth(), game.getHeight());
        Tile leftTile = game.getTile(leftPosition);
        double leftDistance = game.distanceToPlayer(leftPosition);
        if (!leftTile.isObstruction()) {
            newOptions.add(new Option(leftPosition, leftDistance, Direction.LEFT));
        }

        Position downPosition = pp.moveWithin(Direction.DOWN, game.getWidth(), game.getHeight());
        Tile downTile = game.getTile(downPosition);
        double downDistance = game.distanceToPlayer(downPosition);
        if (!downTile.isObstruction()) {
            newOptions.add(new Option(downPosition, downDistance, Direction.DOWN));
        }

        Position rightPosition = pp.moveWithin(Direction.RIGHT, game.getWidth(), game.getHeight());
        Tile rightTile = game.getTile(rightPosition);
        double rightDistance = game.distanceToPlayer(rightPosition);
        if (!rightTile.isObstruction()) {
            newOptions.add(new Option(rightPosition, rightDistance, Direction.RIGHT));
        }

        // get target number from newOptions
        double target;
        if (frightened) {
            // get furthest away
            target = Double.MIN_VALUE;
            for (Option o : newOptions) {
                if (o.getDistance() > target) {
                    target = o.getDistance();
                }
            }
        } else {
            // get closest
            target = Double.MAX_VALUE;
            for (Option o : newOptions) {
                if (o.getDistance() < target) {
                    target = o.getDistance();
                }
            }
        }

        // get first option with target distance
        for (Option o : newOptions) {
            if (o.getDistance() == target) {
                return o.getPosition();
            }
        }

        // this will never happen
        return null;
    }
}

class Option {
    private Position position;
    private double distance;
    private Direction direction;

    public Option(Position position, double distance, Direction direction) {
        this.position = position;
        this.distance = distance;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public double getDistance() {
        return distance;
    }

    public Direction getDirection() {
        return direction;
    }
}
