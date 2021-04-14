
public class Ship extends AnimatedElement {

	public Ship() {
		super(0, 10);
		pose = pose.newX(GameDriver.SCREEN_WIDTH / 2);
		pose = pose.newY(GameDriver.SCREEN_HEIGHT / 2);
	}

	public void turn(double angle) {
		pose = pose.newHeading(pose.getHeading() + angle);
	}

	public void thrust(double acceleration) {
		Vector2D newShipThrust = new Vector2D(pose.getHeading(), acceleration);
		velocity = velocity.add(newShipThrust);
	}

	public void update() {
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_DOWN)) {
			thrust(0.1);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT)) {
			turn(0.1);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT)) {
			turn(-0.1);
		}
		if (!StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_DOWN) && velocity.getMagnitude() > 0) {
			velocity = velocity.newMagnitude(velocity.getMagnitude() * 0.9);
		}
		
		pose = pose.move(velocity);
        pose = pose.getX() < 0.0 ? pose.newX(GameDriver.SCREEN_WIDTH) : pose.newX(pose.getX());
        pose = pose.getY() < 0.0 ? pose.newY(GameDriver.SCREEN_HEIGHT) : pose.newY(pose.getY());
        pose = pose.getX() > GameDriver.SCREEN_WIDTH ? pose.newX(0.0) : pose.newX(pose.getX());
        pose = pose.getY() > GameDriver.SCREEN_HEIGHT ? pose.newY(0.0) : pose.newY(pose.getY());
	}

	public void draw() {
		GameUtils.drawPoseAsTriangle(pose, 10, 20);
	}

}
