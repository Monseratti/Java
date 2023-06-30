public class AreaCalculation {
    public static double TriangleArea(double base, double height){
        return (base*height)/2;
    }
    public static double TriangleArea(double a, double b, double c) {
        double semiPerimeter = (a + b + c) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }
    public static double RhombusArea(double diagonal1, double diagonal2){
        return (diagonal1*diagonal2)/2;
    }
    public static double RectangleArea(double a, double b){
        return a*b;
    }
    public static double SquareArea(double a){
        return a*a;
    }
}
