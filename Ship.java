
public class Ship extends AnimatedElement {

    public Ship() {
        super(new Pose(GameDriver.SCREEN_WIDTH / 2,
                GameDriver.SCREEN_HEIGHT / 2, Math.PI / 2), null, 10);
    }

    public void turn(double angle) {

    }

    public void thrust(double acceleration) {

    }

    public void update() {

    }

    public void draw() {
        GameUtils.drawPoseAsTriangle(pose, 10, 20);
    }
}
