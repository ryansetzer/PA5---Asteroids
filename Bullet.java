
public class Bullet extends AnimatedElement{
    int timeStepsLeft = 20;
    public Bullet(Pose pose, Vector2D velocity) {
        super(pose, velocity, 1.5);
    }
    public void update() {
        timeStepsLeft --;
    }
    public void draw() {
        StdDraw.filledCircle(0, 0, 1.5);
    }
}
