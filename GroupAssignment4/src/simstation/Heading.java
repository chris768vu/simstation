package simstation;

public class Heading {
    private final double xDrt;
    private final double yDrt;

    public Heading(double xDrt, double yDrt) {
        // total is x^2 + y^2
        double total = Math.pow(xDrt, 2) + Math.pow(yDrt, 2);
        double sqrt = Math.sqrt(total);
        this.xDrt = xDrt / sqrt;
        this.yDrt = yDrt / sqrt;
    }

    public double getxDrt() {
        return xDrt;
    }

    public double getyDrt() {
        return yDrt;
    }

    public static Heading random() {
        double xDrt = Math.random();
        double yDrt = Math.sqrt(1 - Math.pow(xDrt, 2));

        double xMul = Math.random() < 0.5 ? 1 : -1;
        double yMul = Math.random() < 0.5 ? 1 : -1;
        return new Heading(xDrt * xMul, yDrt * yMul);
    }
}