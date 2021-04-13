
public enum AsteroidSizeN {
    SMALL(10, 200, 0.2), MEDIUM(20, 100, 0.2), LARGE(30, 50, 0.6);
    private int radius;
    private int points;
    private double probability;
    private AsteroidSizeN(int radius, int points, double probability) {
        this.radius = radius;
        this.points = points;
        this.probability = probability;
    }
    public int getRadius() {
        return radius;
    }
    public int getPoints() {
        return points;
    }
    public static AsteroidSizeN randomSize() {
        AsteroidSizeN result = null;
        return result;
    }
}
