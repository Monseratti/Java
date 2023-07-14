import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class Main {
    public static void main(String[] args) {
        // Підрахунок суми трьох чисел
        SumCalculator sum = (a, b, c) -> a + b + c;
        int sumResult = sum.calculate(3, 4, 5);
        System.out.println("Сума: " + sumResult);

        // Підрахунок добутку трьох цілих чисел
        ProductCalculator product = (a, b, c) -> a * b * c;
        int productResult = product.calculate(2, 4, 6);
        System.out.println("Добуток: " + productResult);

        // Вивід поточного часу
        TimePrinter timePrinter = () -> {
            LocalTime currentTime = LocalTime.now();
            System.out.println("Поточний час: " + currentTime);
        };
        timePrinter.print();

        // Вивід поточної дати
        DatePrinter datePrinter = () -> {
            LocalDate currentDate = LocalDate.now();
            System.out.println("Поточна дата: " + currentDate);
        };
        datePrinter.print();

        // Максимум із двох чисел
        MaxFinder maxFinder = (a, b) -> Math.max(a, b);
        int maxResult = maxFinder.findMax(5, 9);
        System.out.println("Максимум: " + maxResult);

        // Мінімум із двох чисел
        MinFinder minFinder = (a, b) -> Math.min(a, b);
        int minResult = minFinder.findMin(7, 3);
        System.out.println("Мінімум: " + minResult);

        // Факторіал числа
        FactorialCalculator factorialCalculator = (n) -> {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        };
        int factorialResult = factorialCalculator.calculateFactorial(5);
        System.out.println("Факторіал: " + factorialResult);

        // Перевірка, чи є число простим
        PrimeChecker primeChecker = (n) -> {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };
        boolean isPrimeResult = primeChecker.isPrime(13);
        System.out.println("Чи є простим числом: " + isPrimeResult);

        // Лямбда-вираз для знаходження максимуму з трьох значень
        TriMaxFinder<Integer> maxVal = (a, b, c) -> {
            Integer max = a;
            if (b.compareTo(max) > 0) {
                max = b;
            }
            if (c.compareTo(max) > 0) {
                max = c;
            }
            return max;
        };

        // Лямбда-вираз для знаходження мінімуму з трьох значень
        TriMinFinder<Integer> minVal = (a, b, c) -> {
            Integer min = a;
            if (b.compareTo(min) < 0) {
                min = b;
            }
            if (c.compareTo(min) < 0) {
                min = c;
            }
            return min;
        };

        Integer a = 5, b = 9, c = 2;
        Integer maxRes = maxVal.findMax(a, b, c);
        Integer minRes = minVal.findMin(a, b, c);

        System.out.println("Максимум з чисел " + a + ", " + b + ", " + c + ": " + maxRes);
        System.out.println("Мінімум з чисел " + a + ", " + b + ", " + c + ": " + minRes);

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sumEven = sumElements(array, num -> num % 2 == 0);
        System.out.println("Сума парних елементів: " + sumEven);

        int sumOdd = sumElements(array, num -> num % 2 != 0);
        System.out.println("Сума непарних елементів: " + sumOdd);

        int start = 3;
        int end = 8;
        int sumInRange = sumElements(array, num -> num >= start && num <= end);
        System.out.println("Сума елементів у діапазоні від " + start + " до " + end + ": " + sumInRange);

        int x = 3;
        int sumMultipleOfA = sumElements(array, num -> num % x == 0);
        System.out.println("Сума елементів, кратних " + x + ": " + sumMultipleOfA);

    }

    interface SumCalculator {
        int calculate(int a, int b, int c);
    }

    interface ProductCalculator {
        int calculate(int a, int b, int c);
    }

    interface TimePrinter {
        void print();
    }

    interface DatePrinter {
        void print();
    }

    interface MaxFinder {
        int findMax(int a, int b);
    }

    interface MinFinder {
        int findMin(int a, int b);
    }

    interface FactorialCalculator {
        int calculateFactorial(int n);
    }

    interface PrimeChecker {
        boolean isPrime(int n);
    }

    interface TriMaxFinder<T extends Comparable<T>> {
        T findMax(T a, T b, T c);
    }

    interface TriMinFinder<T extends Comparable<T>> {
        T findMin(T a, T b, T c);
    }

    public static int sumElements(int[] array, IntPredicate condition) {
        return Arrays.stream(array)
                .filter(condition)
                .sum();
    }
}
