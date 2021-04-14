import java.awt.Color;

public class Asteroid extends Enemy{
    private AsteroidSize size;
    
    public Asteroid(AsteroidSize size) {
        super(1.0, size.getRadius(), size.getPoints());
        this.size = size;
        int xPosition = GameDriver.GENERATOR.nextInt(GameDriver.SCREEN_WIDTH);
        int yPosition = GameDriver.GENERATOR.nextInt(GameDriver.SCREEN_HEIGHT);
        double asteroidHeading = GameDriver.GENERATOR.nextDouble() * Math.PI;
        super.pose = new Pose(xPosition, yPosition, asteroidHeading);
    }
    public void update() {
        pose = pose.move(velocity);
        pose = pose.getX() < 0.0 ? pose.newX(GameDriver.SCREEN_WIDTH) : pose.newX(pose.getX());
        pose = pose.getY() < 0.0 ? pose.newY(GameDriver.SCREEN_HEIGHT) : pose.newY(pose.getY());
        pose = pose.getX() > GameDriver.SCREEN_WIDTH ? pose.newX(0.0) : pose.newX(pose.getX());
        pose = pose.getY() > GameDriver.SCREEN_HEIGHT ? pose.newY(0.0) : pose.newY(pose.getY());

    }
    public void draw() {
    	StdDraw.setPenColor(Color.cyan);
        StdDraw.circle(pose.xPosition, pose.yPosition, size.getRadius());
        StdDraw.setPenColor(Color.white);
    }
}
