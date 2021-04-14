
public class NumericDisplay extends GameElement{
    private int value;
    private String prefix;
    private int xPosition;
    private int yPosition;
    public NumericDisplay(int xPos, int yPos, int value, String prefix) {
        this.value = value;
        this.prefix = prefix;
        this.xPosition = xPos;
        this.yPosition = yPos;
        
    }
    public void draw() {
        StdDraw.text(xPosition, yPosition, prefix + value);
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

}
