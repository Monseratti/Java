package Figures;

public class Triangle extends Figure{
    double a,b,c;
    @Override
    public double areaCalc() {
        return (a*b)/2;
    }
}
