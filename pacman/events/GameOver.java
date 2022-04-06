package pacman.events;

import pacman.Game;
import pacman.io.GameError;

public class GameOver implements Event {

    private final boolean won;

    public GameOver(boolean won) {
        this.won = won;
    }

    @Override
    public void apply(Game game) {
        // System.out.println(won);
        // System.out.println(game.dotsExist());
        // System.out.println(game.locatePlayer());

        // TODO Auto-generated method stub
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
