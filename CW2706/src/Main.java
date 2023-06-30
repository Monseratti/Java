// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Fraction firstFr = new Fraction(5,7);
        Fraction secondFr = new Fraction(8,44);
        System.out.println(firstFr);
        System.out.println(secondFr);
        System.out.println("Sum: " + firstFr.Sum(secondFr));
        System.out.println("Sub: " + firstFr.Sub(secondFr));
        System.out.println("Mult: " + firstFr.Mult(secondFr));
        System.out.println("Div: " + firstFr.Div(secondFr));
    }
}