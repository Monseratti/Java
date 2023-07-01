package SomethingElse;

public class SimpleMath {
    public static int Max(int a, int b, int c, int d){
        int[] arr = new int[] {
            a,b,c,d
        };
        int max = a;
        for (int x : arr) {
            if (max<x) max = x;
        }
        return max;
    }
    public static int Min(int a, int b, int c, int d){
        int[] arr = new int[] {
                a,b,c,d
        };
        int min = a;
        for (int x : arr) {
            if (min>x) min = x;
        }
        return min;
    }
    public static double Avg(int a, int b, int c, int d){
        return (double) (a+b+c+d)/4;
    }

    public static int Factorial(int x){
        int factorial = 1;
        for (int i = 2; i <= x; i++) {
            factorial*=i;
        }
        return factorial;
    }
}
