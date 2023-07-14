import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Меню:");
            System.out.println("1. Вивести вміст файлу");
            System.out.println("2. Вивести вміст файлу з пагінацією");
            System.out.println("3. Підрахувати кількість входжень слова у файл");
            System.out.println("4. Підрахувати кількість букв, чисел та розділових знаків у файлі");
            System.out.println("5. Замінити слова у файлі");
            System.out.println("6. Об'єднати файли");
            System.out.println("7. Вирізати заборонені слова");
            System.out.println("0. Вийти з програми");
            System.out.print("Введіть номер завдання: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1 -> displayFileContents(scanner);
                case 2 -> displayFileContentsWithPagination(scanner);
                case 3 -> countWordOccurrences(scanner);
                case 4 -> countCharacters(scanner);
                case 5 -> replaceWords(scanner);
                case 6 -> mergeFiles(scanner);
                case 7 -> removeForbiddenWords(scanner);
                case 0 -> System.out.println("До побачення!");
                default -> System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
            System.out.println();
        } while (choice != 0);
    }

    public static void displayFileContents(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        System.out.println("Вміст файлу:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    public static void displayFileContentsWithPagination(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
                if (lineCount % 10 == 0) {
                    System.out.print("Натисніть Enter для продовження...");
                    scanner.nextLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    public static void countWordOccurrences(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        System.out.print("Введіть слово для пошуку: ");
        String searchWord = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int wordCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(searchWord)) {
                        wordCount++;
                    }
                }
            }
            System.out.println("Слово \"" + searchWord + "\" зустрічається " + wordCount + " раз(и) у файлі.");
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }


    public static void countCharacters(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            int lettersCount = 0;
            int digitsCount = 0;
            int punctuationCount = 0;
            int charCode;
            while ((charCode = reader.read()) != -1) {
                char c = (char) charCode;
                if (Character.isLetter(c)) {
                    lettersCount++;
                } else if (Character.isDigit(c)) {
                    digitsCount++;
                } else if (!Character.isWhitespace(c)) {
                    punctuationCount++;
                }
            }
            System.out.println("Кількість літер: " + lettersCount);
            System.out.println("Кількість цифр: " + digitsCount);
            System.out.println("Кількість розділових знаків: " + punctuationCount);
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    public static void replaceWords(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        System.out.print("Введіть слово для пошуку: ");
        String searchWord = scanner.nextLine();
        System.out.print("Введіть слово для заміни: ");
        String replacementWord = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + ".tmp"))) {
            int replaceCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\b" + searchWord + "\\b", replacementWord);
                writer.write(line);
                writer.newLine();
                replaceCount += countOccurrences(line, searchWord);
            }
            System.out.println("Кількість замін: " + replaceCount);
        } catch (IOException e) {
            System.out.println("Помилка при читанні/записі файлу: " + e.getMessage());
        }
    }

    public static void mergeFiles(Scanner scanner) {
        List<String> filePaths = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            System.out.print("Введіть шлях до " + i + "-го файлу: ");
            String filePath = scanner.nextLine();
            filePaths.add(filePath);
        }
        System.out.print("Введіть шлях до вихідного файлу: ");
        String outputFilePath = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            int bytesTransferred = 0;
            for (String filePath : filePaths) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                        bytesTransferred += line.getBytes().length + System.lineSeparator().getBytes().length;
                    }
                } catch (IOException e) {
                    System.out.println("Помилка при читанні файлу " + filePath + ": " + e.getMessage());
                }
            }
            System.out.println("Кількість перенесених байт: " + bytesTransferred);
        } catch (IOException e) {
            System.out.println("Помилка при записі вихідного файлу: " + e.getMessage());
        }
    }

    public static void removeForbiddenWords(Scanner scanner) {
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        System.out.print("Введіть список заборонених слів через кому: ");
        String forbiddenWordsInput = scanner.nextLine();
        String[] forbiddenWords = forbiddenWordsInput.split(",");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + ".tmp"))) {
            Map<String, Integer> removedWordsCount = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : forbiddenWords) {
                    int count = removedWordsCount.getOrDefault(word, 0);
                    line = line.replaceAll("\\b" + word + "\\b", "");
                    count += countOccurrences(line, word);
                    removedWordsCount.put(word, count);
                }
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Кількість вирізаних слів: " + removedWordsCount.size());
            System.out.println("Деталізація:");
            for (Map.Entry<String, Integer> entry : removedWordsCount.entrySet()) {
                System.out.println("Слово \"" + entry.getKey() + "\" вирізано " + entry.getValue() + " раз(и).");
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні/записі файлу: " + e.getMessage());
        }
    }

    private static int countOccurrences(String line, String word) {
        int count = 0;
        int index = line.indexOf(word);
        while (index != -1) {
            count++;
            index = line.indexOf(word, index + 1);
        }
        return count;
    }
}
