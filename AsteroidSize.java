
public class AsteroidSize {
    private int[] Small = {10, 200};
    private int[] Medium = {20, 100};
    private int[] Large = {30, 50};
    int[][] sizes = {Small, Medium, Large};
    private int radius;
    private int points;
    public AsteroidSize() {
        double probability = GameDriver.GENERATOR.nextDouble();
        int [] result = null;
        for (int[] array : sizes) {
            if 
        }
    }
    public int getRadius() {
        return radius;
    }
    public int getPoints() {
        return points;
    }
    public static AsteroidSize randomSize() {
        return null;
    }
}
