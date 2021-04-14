
public abstract class Enemy extends AnimatedElement {
	private int pointValue;

	public Enemy(double speed, double collisionRadius, int pointValue) {
		super(speed, collisionRadius);
		this.pointValue = pointValue;

	}

	public int getPointValue() {
		return pointValue;
	}
}
