
public class GameElement {
    protected Pose pose;
    public GameElement(Pose pose) {
        this.pose = pose;
    }
    public GameElement() {
        int xPosition = GameDriver.GENERATOR.nextInt(GameDriver.SCREEN_WIDTH);
        int yPosition = GameDriver.GENERATOR.nextInt(GameDriver.SCREEN_HEIGHT);
        double gameElementHeading = GameDriver.GENERATOR.nextDouble() * Math.PI;
        this.pose = new Pose(xPosition, yPosition, gameElementHeading);
    }
    public void draw() {
        
    }
}
