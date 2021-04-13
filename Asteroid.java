
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
        
    }
    public void draw() {
        StdDraw.circle(pose.xPosition, pose.yPosition, size.getRadius());
    }
}
