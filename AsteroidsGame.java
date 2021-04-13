import java.util.ArrayList;

public class AsteroidsGame implements Playable{
    ArrayList<GameElement> drawElements;
    ArrayList<AnimatedElement> updateElements;
    ArrayList<AnimatedElement> shipAndBullets;
    ArrayList<Enemy> enemies;
    Ship ship;
    int score;
    int lives;
    NumericDisplay scoreDisplay;
    NumericDisplay livesDisplay;
    
    public AsteroidsGame() {
        this(10);
    }
    public AsteroidsGame(int numAsteroids) {
        drawElements = new ArrayList<>();
        updateElements = new ArrayList<>();
        shipAndBullets = new ArrayList<>();
        enemies = new ArrayList<>();
        for (int i = numAsteroids; i > 0; i++) {
            Asteroid asteroid = new Asteroid(AsteroidSize.randomSize());
            drawElements.add(asteroid);
            updateElements.add(asteroid);
        }
        this.score = 0;
        this.lives = 3;
        this.ship = new Ship();
        scoreDisplay = new NumericDisplay(60, 20, score, "Score: ");
        drawElements.add(scoreDisplay);
        livesDisplay = new NumericDisplay(60, 60, lives, "Lives: ");
        drawElements.add(livesDisplay);

    }

    public void update() {
        for (AnimatedElement ae : updateElements) {
            ae.update();
        }
    }

    public void draw() {
        for (GameElement ge : drawElements) {
            ge.draw();
        }
    }
}
