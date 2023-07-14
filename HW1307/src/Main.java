import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final String RANDOM_NUMBERS_FILE_PATH = "random_numbers.txt";
    private static final String PRIME_NUMBERS_FILE_PATH = "prime_numbers.txt";
    private static final String FACTORIALS_FILE_PATH = "factorials.txt";
    private static final String BANNED_WORDS_FILE_PATH = "banned_words.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        var scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println();
            System.out.println("Меню:");
            System.out.println("1. Заповнення масиву випадковими числами");
            System.out.println("2. Заповнення файлу випадковими числами");
            System.out.println("3. Копіювання директорії");
            System.out.println("4. Пошук файлів та обробка тексту");
            System.out.println("0. Вихід");
            System.out.print("Введіть номер пункту: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

            switch (choice) {
                case 1 -> performArrayProcessing();
                case 2 -> performFileProcessing();
                case 3 -> performDirectoryCopy();
                case 4 -> performFileSearchAndTextProcessing();
                case 0 -> System.out.println("Дякуємо за користування додатком!");
                default -> System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        } while (choice != 0);
    }

    private static void performArrayProcessing() throws InterruptedException {
        var random = new Random();
        int[] array = new int[10];

        Thread fillArrayThread = new Thread(() -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(100);
            }
        });

        Thread sumThread = new Thread(() -> {
            int sum = Arrays.stream(array).sum();
            System.out.println("Сума елементів масиву: " + sum);
        });

        Thread averageThread = new Thread(() -> {
            double average = Arrays.stream(array).average().orElse(0);
            System.out.println("Середнє арифметичне значення масиву: " + average);
        });

        fillArrayThread.start();
        fillArrayThread.join();

        sumThread.start();
        averageThread.start();

        sumThread.join();
        averageThread.join();
    }

    private static void performFileProcessing() throws InterruptedException {
        var random = new Random();
        var path = Path.of(RANDOM_NUMBERS_FILE_PATH);

        Thread fillFileThread = new Thread(() -> {
            try (var writer = new BufferedWriter(new FileWriter(path.toFile()))) {
                for (int i = 0; i < 10; i++) {
                    writer.write(String.valueOf(random.nextInt(10)));
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread primeNumbersThread = new Thread(() -> {
            List<String> primeNumbers;
            try (var reader = new BufferedReader(new FileReader(path.toFile()))) {
                primeNumbers = reader.lines()
                        .filter(Main::isPrimeNumber)
                        .collect(Collectors.toList());
            } catch (IOException e) {
                primeNumbers = Collections.emptyList();
                e.printStackTrace();
            }

            var primeNumbersPath = Path.of(PRIME_NUMBERS_FILE_PATH);
            try (var writer = new BufferedWriter(new FileWriter(primeNumbersPath.toFile()))) {
                for (String number : primeNumbers) {
                    writer.write(number);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread factorialsThread = new Thread(() -> {
            List<String> numbers;
            try (var reader = new BufferedReader(new FileReader(path.toFile()))) {
                numbers = reader.lines().collect(Collectors.toList());
            } catch (IOException e) {
                numbers = Collections.emptyList();
                e.printStackTrace();
            }

            var factorialsPath = Path.of(FACTORIALS_FILE_PATH);
            try (var writer = new BufferedWriter(new FileWriter(factorialsPath.toFile()))) {
                for (String number : numbers) {
                    try {
                        long n = Long.parseLong(number);
                        long factorial = calculateFactorial(n);
                        writer.write(n + "! = " + factorial);
                        writer.newLine();
                    } catch (NumberFormatException e) {
                        writer.write(number + " - Invalid number");
                        writer.newLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        fillFileThread.start();
        fillFileThread.join();

        primeNumbersThread.start();
        factorialsThread.start();

        primeNumbersThread.join();
        factorialsThread.join();
    }

    private static void performDirectoryCopy() {
        try (var scanner = new Scanner(System.in)) {
            System.out.print("Введіть шлях до існуючої директорії: ");
            var sourceDirectoryPath = Path.of(scanner.nextLine());
            System.out.print("Введіть шлях до нової директорії: ");
            var destinationDirectoryPath = Path.of(scanner.nextLine());

            try {
                Files.walk(sourceDirectoryPath)
                        .forEach(source -> {
                            try {
                                Path destination = destinationDirectoryPath.resolve(sourceDirectoryPath.relativize(source));
                                Files.copy(source, destination, StandardCopyOption.COPY_ATTRIBUTES);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                System.out.println("Копіювання директорії успішно завершено.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void performFileSearchAndTextProcessing() throws InterruptedException {
        try (var scanner = new Scanner(System.in)) {
            System.out.print("Введіть шлях до директорії: ");
            var directoryPath = Path.of(scanner.nextLine());
            System.out.print("Введіть слово для пошуку: ");
            var searchWord = scanner.nextLine();

            var searchFilesThread = new Thread(() -> {
                try {
                    List<Path> matchingFiles = Files.find(directoryPath, Integer.MAX_VALUE, (path, attributes) -> {
                        if (!attributes.isRegularFile()) {
                            return false;
                        }

                        try {
                            return Files.readString(path).contains(searchWord);
                        } catch (IOException e) {
                            e.printStackTrace();
                            return false;
                        }
                    }).toList();

                    var mergedContent = new StringBuilder();
                    for (Path file : matchingFiles) {
                        try {
                            mergedContent.append(Files.readString(file)).append(System.lineSeparator());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    var mergedFilePath = Path.of("merged_content.txt");
                    try (var writer = new BufferedWriter(new FileWriter(mergedFilePath.toFile()))) {
                        writer.write(mergedContent.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread textProcessingThread = new Thread(() -> {
                try {
                    searchFilesThread.join();

                    var bannedWords = readBannedWordsFromFile();
                    var mergedFilePath = Path.of("merged_content.txt");
                    var processedContent = new StringBuilder();

                    try (var reader = new BufferedReader(new FileReader(mergedFilePath.toFile()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            for (String bannedWord : bannedWords) {
                                line = line.replaceAll("\\b" + bannedWord + "\\b", "");
                            }
                            processedContent.append(line).append(System.lineSeparator());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Оброблений вміст: ");
                    System.out.println(processedContent);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            });

            searchFilesThread.start();
            textProcessingThread.start();

            searchFilesThread.join();
            textProcessingThread.join();
        }
    }

    private static boolean isPrimeNumber(String number) {
        try {
            int n = Integer.parseInt(number);
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static long calculateFactorial(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }

    private static List<String> readBannedWordsFromFile() throws IOException {
        var path = Path.of(BANNED_WORDS_FILE_PATH);
        if (Files.exists(path)) {
            return Files.readAllLines(path);
        }
        return Collections.emptyList();
    }
}
