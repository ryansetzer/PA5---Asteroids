import java.awt.Color;

public class Bullet extends AnimatedElement {
	int timeStepsLeft = 20;

	public Bullet(Pose pose, Vector2D velocity) {
		super(pose, velocity, 1.5);
	}

	public void update() {
		timeStepsLeft--;
		if (timeStepsLeft == 0) {
			destroyed = true;
		}
        pose = pose.move(velocity);
        pose = pose.getX() < 0.0 ? pose.newX(GameDriver.SCREEN_WIDTH) : pose.newX(pose.getX());
        pose = pose.getY() < 0.0 ? pose.newY(GameDriver.SCREEN_HEIGHT) : pose.newY(pose.getY());
        pose = pose.getX() > GameDriver.SCREEN_WIDTH ? pose.newX(0.0) : pose.newX(pose.getX());
        pose = pose.getY() > GameDriver.SCREEN_HEIGHT ? pose.newY(0.0) : pose.newY(pose.getY());
	}

	public void draw() {
		StdDraw.setPenColor(Color.green);
		StdDraw.filledCircle(pose.getX(), pose.getY(), 1.5);
		StdDraw.setPenColor(Color.white);
	}
}
