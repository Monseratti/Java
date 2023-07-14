import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String EVEN_NUMBERS_FILE_PATH = "even_numbers.txt";
    private static final String ODD_NUMBERS_FILE_PATH = "odd_numbers.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println();
            System.out.println("Меню:");
            System.out.println("1. Знайти максимум і мінімум в масиві");
            System.out.println("2. Знайти суму і середнє арифметичне в масиві");
            System.out.println("3. Розділити числа на парні і непарні");
            System.out.println("4. Пошук слова у файлі");
            System.out.println("0. Вийти з програми");
            System.out.print("Введіть номер пункту: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1 -> findMinMaxInArray(scanner);
                case 2 -> findSumAndAverageInArray(scanner);
                case 3 -> separateNumbers(scanner);
                case 4 -> searchWordInFile(scanner);
                case 0 -> System.out.println("Дякуємо за користування додатком!");
                default -> System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        } while (choice != 0);
    }

    private static void findMinMaxInArray(Scanner scanner) {
        System.out.print("Введіть кількість елементів у масиві: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        int[] array = new int[size];
        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < size; i++) {
            System.out.print("Елемент " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
        }

        Thread minThread = new Thread(() -> {
            int min = Integer.MAX_VALUE;
            for (int num : array) {
                if (num < min) {
                    min = num;
                }
            }
            System.out.println("Мінімум: " + min);
        });

        Thread maxThread = new Thread(() -> {
            int max = Integer.MIN_VALUE;
            for (int num : array) {
                if (num > max) {
                    max = num;
                }
            }
            System.out.println("Максимум: " + max);
        });

        minThread.start();
        maxThread.start();

        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void findSumAndAverageInArray(Scanner scanner) {
        System.out.print("Введіть кількість елементів у масиві: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        int[] array = new int[size];
        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < size; i++) {
            System.out.print("Елемент " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
        }

        Thread sumThread = new Thread(() -> {
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            System.out.println("Сума: " + sum);
        });

        Thread averageThread = new Thread(() -> {
            double average = Arrays.stream(array).average().orElse(0);
            System.out.println("Середнє арифметичне: " + average);
        });

        sumThread.start();
        averageThread.start();

        try {
            sumThread.join();
            averageThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void separateNumbers(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();

        List<Integer> numbers = readNumbersFromFile(filePath);

        Thread evenNumbersThread = new Thread(() -> {
            List<Integer> evenNumbers = new ArrayList<>();
            for (int number : numbers) {
                if (number % 2 == 0) {
                    evenNumbers.add(number);
                }
            }
            saveNumbersToFile(evenNumbers, EVEN_NUMBERS_FILE_PATH);
            System.out.println("Кількість парних чисел: " + evenNumbers.size());
        });

        Thread oddNumbersThread = new Thread(() -> {
            List<Integer> oddNumbers = new ArrayList<>();
            for (int number : numbers) {
                if (number % 2 != 0) {
                    oddNumbers.add(number);
                }
            }
            saveNumbersToFile(oddNumbers, ODD_NUMBERS_FILE_PATH);
            System.out.println("Кількість непарних чисел: " + oddNumbers.size());
        });

        evenNumbersThread.start();
        oddNumbersThread.start();

        try {
            evenNumbersThread.join();
            oddNumbersThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readNumbersFromFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                numbers.add(number);
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні чисел з файлу: " + e.getMessage());
        }
        return numbers;
    }

    private static void saveNumbersToFile(List<Integer> numbers, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int number : numbers) {
                writer.write(String.valueOf(number));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Помилка при збереженні чисел до файлу: " + e.getMessage());
        }
    }

    private static void searchWordInFile(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        System.out.print("Введіть слово для пошуку: ");
        String searchWord = scanner.nextLine();

        File inputFile = new File(filePath);

        Thread searchThread = new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                int occurrences = 0;

                while ((line = reader.readLine()) != null) {
                    occurrences += countWordOccurrences(line, searchWord);
                }

                System.out.println("Слово \"" + searchWord + "\" знайдено " + occurrences + " раз(ів).");
            } catch (IOException e) {
                System.out.println("Помилка при пошуку слова у файлі: " + e.getMessage());
            }
        });

        searchThread.start();

        try {
            searchThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int countWordOccurrences(String line, String word) {
        int count = 0;
        int index = 0;

        while (index != -1) {
            index = line.indexOf(word, index);
            if (index != -1) {
                count++;
                index += word.length();
            }
        }

        return count;
    }
}

