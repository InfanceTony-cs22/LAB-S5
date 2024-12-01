import java.util.Random;

public class PiEstimator {
    public static void main(String[] args) {
        long numPoints = 1000000; // Number of points
        long insideCircle = 0;

        Random random = new Random();

        for (long i = 0; i < numPoints; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y <= 1.0) {
                insideCircle++;
            }
        }

        // Estimate Pi
        double piEstimate = 4.0 * insideCircle / numPoints;
        System.out.println("Estimated π: " + piEstimate);
    }
}
