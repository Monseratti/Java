import java.util.*;

public class DictionaryApp {
    private static Map<String, List<String>> dictionary;
    private static Map<String, Integer> popularity;

    public static void main(String[] args) {
        dictionary = new HashMap<>();
        popularity = new HashMap<>();

        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Dictionary App ===");
            System.out.println("1. Add translation");
            System.out.println("2. Display translations");
            System.out.println("3. Add or update word");
            System.out.println("4. Remove word");
            System.out.println("5. Display top 10 popular words");
            System.out.println("6. Display top 10 unpopular words");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            var choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> addTranslation(scanner);
                case 2 -> displayTranslations(scanner);
                case 3 -> addOrUpdateWord(scanner);
                case 4 -> removeWord(scanner);
                case 5 -> displayTopPopularWords();
                case 6 -> displayTopUnpopularWords();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTranslation(Scanner scanner) {
        System.out.print("Enter the word to translate: ");
        var word = scanner.nextLine();

        System.out.print("Enter the translation: ");
        var translation = scanner.nextLine();

        var translations = dictionary.getOrDefault(word, new ArrayList<>());
        translations.add(translation);
        dictionary.put(word, translations);

        var count = popularity.getOrDefault(word, 0);
        popularity.put(word, count + 1);

        System.out.println("Translation added successfully.");
    }

    private static void displayTranslations(Scanner scanner) {
        System.out.print("Enter the word to display translations: ");
        var word = scanner.nextLine();

        var translations = dictionary.get(word);

        if (translations != null) {
            System.out.println("Translations of " + word + ":");
            translations.forEach(translation -> System.out.println("- " + translation));
        } else {
            System.out.println("No translations found for " + word + ".");
        }
    }

    private static void addOrUpdateWord(Scanner scanner) {
        System.out.print("Enter the word to add or update: ");
        var word = scanner.nextLine();

        System.out.print("Enter the translation: ");
        var translation = scanner.nextLine();

        var translations = new ArrayList<String>();
        translations.add(translation);
        dictionary.put(word, translations);

        var count = popularity.getOrDefault(word, 0);
        popularity.put(word, count + 1);

        System.out.println("Word added or updated successfully.");
    }

    private static void removeWord(Scanner scanner) {
        System.out.print("Enter the word to remove: ");
        var word = scanner.nextLine();

        dictionary.remove(word);
        popularity.remove(word);

        System.out.println("Word removed successfully.");
    }

    private static void displayTopPopularWords() {
        var entries = new ArrayList<>(popularity.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        var count = 0;
        System.out.println("Top 10 popular words:");
        for (var entry : entries) {
            if (count >= 10) {
                break;
            }
            System.out.println("- " + entry.getKey() + " (Count: " + entry.getValue() + ")");
            count++;
        }
    }

    private static void displayTopUnpopularWords() {
        var entries = new ArrayList<>(popularity.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        var count = 0;
        System.out.println("Top 10 unpopular words:");
        for (var entry : entries) {
            if (count >= 10) {
                break;
            }
            System.out.println("- " + entry.getKey() + " (Count: " + entry.getValue() + ")");
            count++;
        }
    }
}
