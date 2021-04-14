import java.awt.Color;
import java.util.ArrayList;

public class AsteroidsGame implements Playable {
	ArrayList<GameElement> drawElements;
	ArrayList<AnimatedElement> updateElements;
	ArrayList<AnimatedElement> shipAndBullets;
	ArrayList<Enemy> enemies;
	Ship ship;
	int score;
	int lives;
	int asteroids;
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
		for (int i = numAsteroids; i > 0; i--) {
			Asteroid asteroid = new Asteroid(AsteroidSize.randomSize());
			drawElements.add(asteroid);
			updateElements.add(asteroid);
		}
		for (int i = 0; i < 50; i++) {
			Star star = new Star();
			drawElements.add(star);
		}
		this.score = 0;
		this.lives = 3;
		this.asteroids = numAsteroids;
		this.ship = new Ship();
		shipAndBullets.add(ship);
		drawElements.add(ship);
		updateElements.add(ship);

		scoreDisplay = new NumericDisplay(60, GameDriver.SCREEN_HEIGHT - 20, score, "Score: ");
		drawElements.add(scoreDisplay);
		livesDisplay = new NumericDisplay(60, GameDriver.SCREEN_HEIGHT - 60, lives, "Lives: ");
		drawElements.add(livesDisplay);

	}

	public void update() { 
		
		if (lives == 0) {
			StdDraw.pause(100000000);
		}
		
		for (AnimatedElement ae : updateElements) {
			ae.update();
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
			Ship currentShip = null;
			for (int i = 0; i < updateElements.size(); i++) {
				if (updateElements.get(i) instanceof Ship) {
					currentShip = (Ship) updateElements.get(i);
				}
			}
			Bullet bullet = new Bullet(new Pose(currentShip.pose.getX(), currentShip.pose.getY(), currentShip.pose.getHeading()),
					new Vector2D(currentShip.pose.getHeading(), 20)); // pose, vector2d
			shipAndBullets.add(bullet);
			drawElements.add(bullet);
			updateElements.add(bullet);
		}
		for (int i = 0; i < updateElements.size(); i++) {
			if (updateElements.get(i).destroyed) {
				GameElement temp = updateElements.get(i);
				updateElements.remove(temp);
				drawElements.remove(temp);
				shipAndBullets.remove(temp);
			}
		}
		if (GameDriver.GENERATOR.nextDouble() < 0.005) {
			Saucer saucer = new Saucer();
			drawElements.add(saucer);
			updateElements.add(saucer);
		}
		for (int i = 0; i < updateElements.size(); i++) {
			for (int j = 0; j < updateElements.size(); j++) {
				if (i != j && updateElements.get(i).checkCollision(updateElements.get(j))
						&& !(updateElements.get(i) instanceof Ship && updateElements.get(j) instanceof Bullet)
						&& !(updateElements.get(i) instanceof Bullet && updateElements.get(j) instanceof Ship)
						&& !(updateElements.get(i) instanceof Asteroid && updateElements.get(i) instanceof Asteroid)) {
					if (updateElements.get(i) instanceof Bullet && !(updateElements.get(j) instanceof Bullet)) {
						score += ((Enemy)updateElements.get(j)).getPointValue();
						scoreDisplay.setValue(score);
					}
					updateElements.get(i).destroyed = true;
					updateElements.get(j).destroyed = true;
				}
			}
		}
		int count = 0;
		for (AnimatedElement ae : updateElements) {
			if (ae instanceof Ship) {
				count++;
			}
		}
		if (count == 0) {
			lives--;
			livesDisplay.setValue(lives);
			Ship ship = new Ship();
			shipAndBullets.add(ship);
			drawElements.add(ship);
			updateElements.add(ship);
		}
		count = 0;
		for (AnimatedElement ae : updateElements) {
			if (ae instanceof Asteroid) {
				count++;
			}
		}

		if (count == 0) {
			for (int i = asteroids; i > 0; i--) {
				Asteroid asteroid = new Asteroid(AsteroidSize.randomSize());
				drawElements.add(asteroid);
				updateElements.add(asteroid);
			}
		}
		
	}

	public void draw() {
		StdDraw.setPenColor(Color.white);
		for (GameElement ge : drawElements) {
			ge.draw();
		}
	}
}
