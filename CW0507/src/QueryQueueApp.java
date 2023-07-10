import java.time.LocalDateTime;
import java.util.*;

public class QueryQueueApp {
    private static Queue<Query> queryQueue = new PriorityQueue<>(Comparator.comparingInt(Query::priority));
    private static Queue<QueryStatistics> queryStatisticsQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1 -> addQuery(scanner);
                    case 2 -> sendQueryToServer();
                    case 3 -> displayQueryQueue();
                    case 4 -> displayQueryStatistics();
                    case 5 -> System.out.println("Exiting the program. Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine(); // Consume invalid input
                choice = 0; // Set choice to an invalid value to repeat the loop
            }
            System.out.println();
        } while (choice != 5);
    }

    private static void displayMenu() {
        System.out.println("---- Query Queue Application ----");
        System.out.println("1. Add a query to the queue");
        System.out.println("2. Send queries to server");
        System.out.println("3. Display the query queue");
        System.out.println("4. Display the query statistics");
        System.out.println("5. Exit");
    }

    private static void addQuery(Scanner scanner) {
        System.out.print("Enter the user: ");
        String user = scanner.nextLine();
        System.out.print("Enter the priority (1-5): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Query query = new Query(user, priority);
        queryQueue.add(query);
        System.out.println("Query added to the queue.");
    }

    private static void sendQueryToServer() {
        System.out.println("Sending queries to the server in priority order:");
        while (!queryQueue.isEmpty()) {
            Query query = queryQueue.poll();
            queryStatisticsQueue.add(new QueryStatistics(query.user(), LocalDateTime.now()));
            System.out.println("Sent Query: " + query);
        }
    }

    private static void displayQueryQueue() {
        System.out.println("Query Queue:");
        queryQueue.forEach(System.out::println);
    }

    private static void displayQueryStatistics() {
        System.out.println("Query Statistics:");
        queryStatisticsQueue.forEach(System.out::println);
    }

    private record Query(String user, int priority) {
        @Override
        public String toString() {
            return "User: " + user + ", Priority: " + priority;
        }
    }

    private record QueryStatistics(String user, LocalDateTime timestamp) {
        @Override
        public String toString() {
            return "User: " + user + ", Timestamp: " + timestamp;
        }
    }
}
