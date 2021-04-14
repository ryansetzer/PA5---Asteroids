
public class Saucer extends Enemy {

	public Saucer() {
		super(2, 10, 400);
	}

	public void draw() {
		StdDraw.rectangle(pose.getX(), pose.getY(), 10, 5);
	}

	public void update() {
		pose = pose.move(velocity);
		if (GameDriver.GENERATOR.nextDouble() < 0.05) {
			velocity = velocity.newHeading(GameDriver.GENERATOR.nextDouble() * 2 * Math.PI);
		}
		if (pose.getX() < 0 || pose.getY() < 0 || pose.getX() > GameDriver.SCREEN_WIDTH
				|| pose.getY() > GameDriver.SCREEN_HEIGHT) {
			destroyed = true;
		}
	}
}
