
public abstract class AnimatedElement extends GameElement {
	protected Vector2D velocity;
	protected double collisionRadius;
	protected boolean destroyed;

	public AnimatedElement(Pose pose, Vector2D velocity, double collisionRadius) {
		super(pose);
		this.velocity = velocity;
		this.collisionRadius = collisionRadius;
	}

	public AnimatedElement(double speed, double collisionRadius) {
		super();
		this.velocity = new Vector2D(GameDriver.GENERATOR.nextDouble() * 2 * Math.PI, speed);
		this.collisionRadius = collisionRadius;
	}
	

	public abstract void update();

	public boolean checkCollision(AnimatedElement other) {
		double distance = Math
				.sqrt(Math.pow(pose.getX() - other.pose.getX(), 2) + Math.pow(pose.getY() - other.pose.getY(), 2));
		return ((collisionRadius + other.collisionRadius) > distance);
	}
}
