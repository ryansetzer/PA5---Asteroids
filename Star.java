
public class Star extends GameElement{
    public Star() {
        super();
    }
    public void draw() {
        StdDraw.filledCircle(pose.xPosition, pose.yPosition, 1);
    }
}
