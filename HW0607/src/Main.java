import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.function.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Завдання 1
        // Перевірка чи є рік високосним
        IntPredicate isLeapYear = year -> year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        int year = 2020;
        boolean isLeap = isLeapYear.test(year);
        System.out.println(year + " рік є високосним: " + isLeap);

        // Підрахунок кількості днів між двома датами
        BiFunction<LocalDate, LocalDate, Integer> daysBetween = (date1, date2) -> Period.between(date1, date2).getDays();
        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 12, 31);
        int days = daysBetween.apply(date1, date2);
        System.out.println("Кількість днів між " + date1 + " і " + date2 + ": " + days);

        // Підрахунок кількості повних неділь між двома датами
        BiFunction<LocalDate, LocalDate, Long> sundaysCount = (startDate, endDate) ->
                IntStream.iterate(0, i -> i + 1)
                        .mapToObj(startDate::plusDays)
                        .takeWhile(date -> !date.isAfter(endDate))
                        .filter(date -> date.getDayOfWeek() == DayOfWeek.SUNDAY)
                        .count();
        long countSundays = sundaysCount.apply(date1, date2);
        System.out.println("Кількість повних неділь між " + date1 + " і " + date2 + ": " + countSundays);

        // Підрахунок дня тижня по отриманій даті
        Function<LocalDate, String> dayOfWeek = date -> date.getDayOfWeek().name();
        LocalDate date3 = LocalDate.of(1969, 7, 20);
        String day = dayOfWeek.apply(date3);
        System.out.println("День тижня для " + date3 + ": " + day);

        // Завдання 2
        // Сума двох дробів
        BinaryOperator<Double> sumFractions = (num1, num2) -> num1 + num2;
        double numerator1 = 1, denominator1 = 5;
        double numerator2 = 2, denominator2 = 3;
        double sum = sumFractions.apply(numerator1 / denominator1, numerator2 / denominator2);
        System.out.println("Сума дробів " + numerator1 + "/" + denominator1 + " та " + numerator2 + "/" + denominator2 + ": " + sum);

        // Різниця двох дробів
        BinaryOperator<Double> diffFractions = (num1, num2) -> num1 - num2;
        double diff = diffFractions.apply(numerator1 / denominator1, numerator2 / denominator2);
        System.out.println("Різниця дробів " + numerator1 + "/" + denominator1 + " та " + numerator2 + "/" + denominator2 + ": " + diff);

        // Множення двох дробів
        BinaryOperator<Double> multiplyFractions = (num1, num2) -> num1 * num2;
        double multiply = multiplyFractions.apply(numerator1 / denominator1, numerator2 / denominator2);
        System.out.println("Множення дробів " + numerator1 + "/" + denominator1 + " та " + numerator2 + "/" + denominator2 + ": " + multiply);

        // Ділення двох дробів
        BinaryOperator<Double> divideFractions = (num1, num2) -> num1 / num2;
        double divide = divideFractions.apply(numerator1 / denominator1, numerator2 / denominator2);
        System.out.println("Ділення дробів " + numerator1 + "/" + denominator1 + " на " + numerator2 + "/" + denominator2 + ": " + divide);

        // Завдання 3
        // Максимум із чотирьох
        BinaryOperator<Integer> maxOfFour = (num1, num2) -> Math.max(num1, num2);
        int num1 = 5, num2 = 10, num3 = 3, num4 = 8;
        int max = maxOfFour.apply(maxOfFour.apply(num1, num2), maxOfFour.apply(num3, num4));
        System.out.println("Максимум з чисел " + num1 + ", " + num2 + ", " + num3 + " і " + num4 + ": " + max);

        // Мінімум із чотирьох
        BinaryOperator<Integer> minOfFour = (num5, num6) -> Math.min(num5, num6);
        int min = minOfFour.apply(minOfFour.apply(num1, num2), minOfFour.apply(num3, num4));
        System.out.println("Мінімум з чисел " + num1 + ", " + num2 + ", " + num3 + " і " + num4 + ": " + min);

        // Завдання 4
        int[] array = {-1,-3,-5, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Перевірка на рівність конкретному числу
        IntPredicate isEqualToNum = num -> num == 3;
        int sumEqualNum = sumElements(array, isEqualToNum);
        System.out.println("Сума елементів, що дорівнюють 3: " + sumEqualNum);

        // Число не знаходиться в діапазоні від A до B
        IntPredicate isNotInRange = num -> num < 4 || num > 8;
        int sumNotInRange = sumElements(array, isNotInRange);
        System.out.println("Сума елементів, що не знаходяться в діапазоні від 4 до 8: " + sumNotInRange);

        // Перевірка на додатне число
        IntPredicate isPositiveNum = num -> num > 0;
        int sumPositiveNum = sumElements(array, isPositiveNum);
        System.out.println("Сума додатних елементів: " + sumPositiveNum);

        // Перевірка на від'ємне число
        IntPredicate isNegativeNum = num -> num < 0;
        int sumNegativeNum = sumElements(array, isNegativeNum);
        System.out.println("Сума від'ємних елементів: " + sumNegativeNum);
    }

    // Метод для підрахунку суми елементів масиву, що відповідають умові лямбда-виразу
    public static int sumElements(int[] array, IntPredicate condition) {
        return Arrays.stream(array)
                .filter(condition)
                .sum();
    }
}
