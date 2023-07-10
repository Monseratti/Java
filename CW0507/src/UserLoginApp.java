import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLoginApp {
    private static final Map<String, String> userCredentials = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> addUser(scanner);
                case 2 -> removeUser(scanner);
                case 3 -> checkUserExist(scanner);
                case 4 -> replacePassword(scanner);
                case 5 -> replaceLogin(scanner);
                case 6 -> System.out.println("Exiting the program. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 6);
    }

    private static void displayMenu() {
        System.out.println("---- User Login Application ----");
        System.out.println("1. Add a new user");
        System.out.println("2. Remove a user");
        System.out.println("3. Check if a user exists");
        System.out.println("4. Replace user's password");
        System.out.println("5. Replace user's login");
        System.out.println("6. Exit");
    }

    private static void addUser(Scanner scanner) {
        System.out.print("Enter the user's login: ");
        String login = scanner.nextLine();
        System.out.print("Enter the user's password: ");
        String password = scanner.nextLine();
        if (userCredentials.containsKey(login)) {
            System.out.println("User with login '" + login + "' already exists. User not added.");
        } else {
            userCredentials.put(login, password);
            System.out.println("User added successfully.");
        }
    }

    private static void removeUser(Scanner scanner) {
        System.out.print("Enter the user's login to remove: ");
        String login = scanner.nextLine();
        if (userCredentials.containsKey(login)) {
            userCredentials.remove(login);
            System.out.println("User with login '" + login + "' removed successfully.");
        } else {
            System.out.println("User with login '" + login + "' does not exist.");
        }
    }

    private static void checkUserExist(Scanner scanner) {
        System.out.print("Enter the user's login to check: ");
        String login = scanner.nextLine();
        if (userCredentials.containsKey(login)) {
            System.out.println("User with login '" + login + "' exists.");
        } else {
            System.out.println("User with login '" + login + "' does not exist.");
        }
    }

    private static void replacePassword(Scanner scanner) {
        System.out.print("Enter the user's login to replace the password: ");
        String login = scanner.nextLine();
        if (userCredentials.containsKey(login)) {
            System.out.print("Enter the new password: ");
            String newPassword = scanner.nextLine();
            userCredentials.put(login, newPassword);
            System.out.println("Password replaced successfully.");
        } else {
            System.out.println("User with login '" + login + "' does not exist. Password not replaced.");
        }
    }

    private static void replaceLogin(Scanner scanner) {
        System.out.print("Enter the user's current login to replace: ");
        String currentLogin = scanner.nextLine();
        if (userCredentials.containsKey(currentLogin)) {
            System.out.print("Enter the new login: ");
            String newLogin = scanner.nextLine();
            String password = userCredentials.remove(currentLogin);
            userCredentials.put(newLogin, password);
            System.out.println("Login replaced successfully.");
        } else {
            System.out.println("User with login '" + currentLogin + "' does not exist. Login not replaced.");
        }
    }
}
