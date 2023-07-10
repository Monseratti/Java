
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NumberListApp {
    private static final List<Integer> numberList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> addElement(scanner);
                case 2 -> removeElement(scanner);
                case 3 -> showList();
                case 4 -> checkElement(scanner);
                case 5 -> replaceElement(scanner);
                case 6 -> System.out.println("Exiting the program. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 6);
    }

    private static void displayMenu() {
        System.out.println("---- Number List Application ----");
        System.out.println("1. Add an element to the list");
        System.out.println("2. Remove an element from the list");
        System.out.println("3. Show the list");
        System.out.println("4. Check if an element exists in the list");
        System.out.println("5. Replace an element in the list");
        System.out.println("6. Exit");
    }

    private static void addElement(Scanner scanner) {
        System.out.print("Enter the number to add: ");
        int number = scanner.nextInt();
        numberList.add(number);
        System.out.println("Number " + number + " added to the list.");
    }

    private static void removeElement(Scanner scanner) {
        System.out.print("Enter the number to remove: ");
        int number = scanner.nextInt();
        if (numberList.remove(Integer.valueOf(number))) {
            System.out.println("Number " + number + " removed from the list.");
        } else {
            System.out.println("Number " + number + " is not found in the list.");
        }
    }

    private static void showList() {
        System.out.println("Number List: " + numberList);
    }

    private static void checkElement(Scanner scanner) {
        System.out.print("Enter the number to check: ");
        int number = scanner.nextInt();
        if (numberList.contains(number)) {
            System.out.println("Number " + number + " exists in the list.");
        } else {
            System.out.println("Number " + number + " does not exist in the list.");
        }
    }

    private static void replaceElement(Scanner scanner) {
        System.out.print("Enter the number to replace: ");
        int numberToReplace = scanner.nextInt();
        System.out.print("Enter the new number: ");
        int newNumber = scanner.nextInt();
        if (numberList.contains(numberToReplace)) {
            int index = numberList.indexOf(numberToReplace);
            numberList.set(index, newNumber);
            System.out.println("Number " + numberToReplace + " replaced with " + newNumber + " in the list.");
        } else {
            System.out.println("Number " + numberToReplace + " is not found in the list. Replacement not performed.");
        }
    }
}