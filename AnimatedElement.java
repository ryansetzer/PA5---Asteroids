
public class AnimatedElement extends GameElement{
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
        this.collisionRadius = collisionRadius;
    }
    public void update() {
        
    }
    public boolean checkCollision(AnimatedElement other) {
        return false;
    }
}
