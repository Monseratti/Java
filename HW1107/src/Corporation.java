import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Corporation {
    private List<Employee> employees;
    private final String dataFilePath;

    public Corporation(String dataFilePath) {
        this.employees = new ArrayList<>();
        this.dataFilePath = dataFilePath;
        loadEmployeesFromDataFile();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void editEmployee(int employeeId, Employee editedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employee.setFirstName(editedEmployee.getFirstName());
                employee.setLastName(editedEmployee.getLastName());
                employee.setAge(editedEmployee.getAge());
                break;
            }
        }
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(employee -> employee.getId() == employeeId);
    }

    public List<Employee> searchEmployeesByLastName(String lastName) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }

    public List<Employee> searchEmployeesByAge(int age) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() == age) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }

    public List<Employee> searchEmployeesByLastNameStartingWith(char letter) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getLastName().charAt(0) == letter) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }

    public void saveEmployeesToDataFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            outputStream.writeObject(employees);
            System.out.println("Дані збережено у файл " + dataFilePath);
        } catch (IOException e) {
            System.out.println("Помилка при збереженні даних у файл: " + e.getMessage());
        }
    }

    private void loadEmployeesFromDataFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dataFilePath))) {
            employees = (List<Employee>) inputStream.readObject();
            System.out.println("Дані завантажено з файлу " + dataFilePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при завантаженні даних з файлу: " + e.getMessage());
        }
    }

    public void displayEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void displayAllEmployees() {
        System.out.println("Список співробітників:");
        displayEmployees(employees);
    }

    public void displayEmployeesByAge(int age) {
        System.out.println("Співробітники віком " + age + ":");
        List<Employee> foundEmployees = searchEmployeesByAge(age);
        displayEmployees(foundEmployees);
    }

    public void displayEmployeesByLastNameStartingWith(char letter) {
        System.out.println("Співробітники з прізвищем, що починається на букву " + letter + ":");
        List<Employee> foundEmployees = searchEmployeesByLastNameStartingWith(letter);
        displayEmployees(foundEmployees);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу даних: ");
        String dataFilePath = scanner.nextLine();

        Corporation corporation = new Corporation(dataFilePath);
        int choice;
        do {
            System.out.println();
            System.out.println("Меню:");
            System.out.println("1. Додати співробітника");
            System.out.println("2. Редагувати співробітника");
            System.out.println("3. Видалити співробітника");
            System.out.println("4. Пошук співробітника за прізвищем");
            System.out.println("5. Вивести всіх співробітників");
            System.out.println("6. Вивести співробітників за віком");
            System.out.println("7. Вивести співробітників за початковою буквою прізвища");
            System.out.println("0. Вийти з програми");
            System.out.print("Введіть номер пункту: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1 -> {
                    System.out.print("Введіть ім'я співробітника: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Введіть прізвище співробітника: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Введіть вік співробітника: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    Employee employee = new Employee(firstName, lastName, age);
                    corporation.addEmployee(employee);
                    System.out.println("Співробітник доданий до корпорації.");
                }
                case 2 -> {
                    System.out.print("Введіть ID співробітника для редагування: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Введіть нове ім'я співробітника: ");
                    String newFirstName = scanner.nextLine();
                    System.out.print("Введіть нове прізвище співробітника: ");
                    String newLastName = scanner.nextLine();
                    System.out.print("Введіть новий вік співробітника: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    Employee editedEmployee = new Employee(newFirstName, newLastName, newAge);
                    corporation.editEmployee(employeeId, editedEmployee);
                    System.out.println("Співробітник відредагований.");
                }
                case 3 -> {
                    System.out.print("Введіть ID співробітника для видалення: ");
                    int employeeIdToRemove = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    corporation.removeEmployee(employeeIdToRemove);
                    System.out.println("Співробітник видалений.");
                }
                case 4 -> {
                    System.out.print("Введіть прізвище для пошуку: ");
                    String searchLastName = scanner.nextLine();
                    List<Employee> foundEmployees = corporation.searchEmployeesByLastName(searchLastName);
                    if (foundEmployees.isEmpty()) {
                        System.out.println("Співробітників з таким прізвищем не знайдено.");
                    } else {
                        System.out.println("Знайдені співробітники:");
                        corporation.displayEmployees(foundEmployees);
                    }
                }
                case 5 -> corporation.displayAllEmployees();
                case 6 -> {
                    System.out.print("Введіть вік для пошуку: ");
                    int searchAge = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    corporation.displayEmployeesByAge(searchAge);
                }
                case 7 -> {
                    System.out.print("Введіть початкову букву прізвища для пошуку: ");
                    char searchLetter = scanner.nextLine().charAt(0);
                    corporation.displayEmployeesByLastNameStartingWith(searchLetter);
                }
                case 0 -> {
                    corporation.saveEmployeesToDataFile();
                    System.out.println("Дякуємо за користування додатком!");
                }
                default -> System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        } while (choice != 0);
    }
}
