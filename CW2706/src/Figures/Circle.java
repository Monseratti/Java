package Figures;

public class Circle extends Figure {
    double r;

    public Circle() {
        this(1);
    }

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double areaCalc() {
        return Math.PI * r * r;
    }
}
