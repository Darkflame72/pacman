package pacman.events;

import pacman.Game;
import pacman.io.GameError;

/**
 * Represents a game over event.
 * 
 * @author Leon J. Bowie
 */
public class GameOver implements Event {

    /**
     * Win state of the game over event.
     */
    private final boolean won;

    /**
     * Construct a new game over object for a given state.
     *
     * @param won Indicates whether the game is won or not.
     */
    public GameOver(boolean won) {
        this.won = won;
    }

    @Override
    public void apply(Game game) {
        if (won && !game.dotsExist()) {
            // correct
            return;
        }

        if (!won && game.locatePlayer() == null) {
            // correct
            return;
        }

        throw new GameError("Incorrect game over event");

    }

}
