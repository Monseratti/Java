import java.io.*;
import java.util.*;

public class FileProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Меню:");
            System.out.println("1. Перевірка збігу рядків у двох файлах");
            System.out.println("2. Знайти найдовший рядок у файлі");
            System.out.println("3. Обробка масивів чисел з файлу");
            System.out.println("4. Зберегти масив в файлі");
            System.out.println("0. Вийти з програми");
            System.out.print("Введіть номер завдання: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1 -> compareFileLines(scanner);
                case 2 -> findLongestLine(scanner);
                case 3 -> processArraysFromFile(scanner);
                case 4 -> saveArrayToFile(scanner);
                case 0 -> System.out.println("До побачення!");
                default -> System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
            System.out.println();
        } while (choice != 0);
    }

    public static void compareFileLines(Scanner scanner) {
        System.out.print("Введіть шлях до першого файлу: ");
        String filePath1 = scanner.nextLine();
        System.out.print("Введіть шлях до другого файлу: ");
        String filePath2 = scanner.nextLine();
        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {
            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            int lineNumber = 1;
            boolean isDifferent = false;
            while (line1 != null && line2 != null) {
                if (!line1.equals(line2)) {
                    System.out.println("Рядок " + lineNumber + " не збігається:");
                    System.out.println("Файл 1: " + line1);
                    System.out.println("Файл 2: " + line2);
                    isDifferent = true;
                }
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                lineNumber++;
            }
            if (!isDifferent) {
                System.out.println("Рядки у файлах збігаються.");
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлів: " + e.getMessage());
        }
    }

    public static void findLongestLine(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String longestLine = "";
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > longestLine.length()) {
                    longestLine = line;
                }
            }
            System.out.println("Найдовший рядок:");
            System.out.println("Довжина: " + longestLine.length());
            System.out.println("Рядок: " + longestLine);
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    public static void processArraysFromFile(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<int[]> arrays = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split("\\s+");
                int[] array = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    array[i] = Integer.parseInt(numbers[i]);
                }
                arrays.add(array);
            }

            for (int i = 0; i < arrays.size(); i++) {
                int[] array = arrays.get(i);
                System.out.println("Масив " + (i + 1) + ": " + Arrays.toString(array));
                int min = Arrays.stream(array).min().orElse(0);
                int max = Arrays.stream(array).max().orElse(0);
                int sum = Arrays.stream(array).sum();
                System.out.println("Мінімум: " + min);
                System.out.println("Максимум: " + max);
                System.out.println("Сума: " + sum);
            }

            int totalSum = arrays.stream()
                    .flatMapToInt(Arrays::stream)
                    .sum();
            System.out.println("Загальна сума всіх масивів: " + totalSum);

        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    public static void saveArrayToFile(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        System.out.print("Введіть масив цілих чисел, розділених пробілами: ");
        String input = scanner.nextLine();
        String[] numbers = input.split("\\s+");
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(Arrays.toString(array));
            writer.newLine();
            writer.write(getEvenNumbersString(array));
            writer.newLine();
            writer.write(getOddNumbersString(array));
            writer.newLine();
            writer.write(getReversedArrayString(array));
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    private static String getEvenNumbersString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            if (num % 2 == 0) {
                sb.append(num).append(" ");
            }
        }
        return sb.toString().trim();
    }

    private static String getOddNumbersString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            if (num % 2 != 0) {
                sb.append(num).append(" ");
            }
        }
        return sb.toString().trim();
    }

    private static String getReversedArrayString(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return Arrays.toString(reversedArray);
    }
}
