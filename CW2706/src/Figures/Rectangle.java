package Figures;

import SomethingElse.AreaCalculation;

public class Rectangle extends Figure {
    double a;
    double b;

    public Rectangle() {
        this(1, 1);
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double areaCalc() {
        return AreaCalculation.RectangleArea(this.a, this.b);
    }
}
