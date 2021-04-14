
public enum AsteroidSize {
    SMALL(10, 200, 0.2), MEDIUM(20, 100, 0.2), LARGE(30, 50, 0.6);
    private int radius;
    private int points;
    private double probability;
    private AsteroidSize(int radius, int points, double probability) {
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
    /*
     * Collaborated with Stuart Martin.
     * @return 
     */
    public static AsteroidSize randomSize() {
        AsteroidSize result = values()[GameDriver.GENERATOR.nextInt(values().length)];
        return result;
    }
}
