package Snake_And_Ladder.game;

public class Game {
    private final GameEngine engine;

    public Game(GameEngine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.play();
    }
}
