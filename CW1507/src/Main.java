import java.util.*;

// Клас "Автомобіль"
record Car(String name, int year, double price, String color, double engineVolume) {

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }
}

// Клас "Телевізор"
record Television(String modelName, int year, double price, double diagonal, String manufacturer) {

    @Override
    public String toString() {
        return "Television{" +
                "modelName='" + modelName + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", diagonal=" + diagonal +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Завдання 1: Робота зі списком цілих чисел
        List<Integer> numbers = new Random().ints(20, -10, 10)
                .boxed()
                .toList();

        System.out.println("Завдання 1:");
        System.out.println("Список чисел: " + numbers);

        long countEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Кількість парних чисел: " + countEven);

        long countOdd = numbers.stream()
                .filter(n -> n % 2 != 0)
                .count();
        System.out.println("Кількість непарних чисел: " + countOdd);

        long countZero = numbers.stream()
                .filter(n -> n == 0)
                .count();
        System.out.println("Кількість нулів: " + countZero);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число: ");
        int userInput = scanner.nextInt();
        long countUserInput = numbers.stream()
                .filter(n -> n == userInput)
                .count();
        System.out.println("Кількість чисел, рівних " + userInput + ": " + countUserInput);
        System.out.println();

        // Завдання 2: Робота зі списком назв міст
        List<String> cities = Arrays.asList("Київ", "Львів", "Одеса", "Харків", "Київ", "Дніпро", "Львів");

        System.out.println("Завдання 2:");
        System.out.println("Список міст: " + cities);

        List<String> longCities = cities.stream()
                .filter(city -> city.length() > 6)
                .toList();
        System.out.println("Міста довжиною більше шести символів: " + longCities);

        System.out.print("Введіть назву міста: ");
        String userCity = scanner.next();
        long countUserCity = cities.stream()
                .filter(city -> city.equals(userCity))
                .count();
        System.out.println("Кількість згадувань міста " + userCity + ": " + countUserCity);

        System.out.print("Введіть літеру: ");
        String letter = scanner.next();
        List<String> citiesByLetter = cities.stream()
                .filter(city -> city.startsWith(letter.toUpperCase()))
                .toList();
        System.out.println("Міста, що починаються з літери " + letter + ": " + citiesByLetter);
        System.out.println();

        // Завдання 3: Робота зі списком автомобілів
        List<Car> cars = Arrays.asList(
                new Car("Toyota Camry", 2019, 25000, "Сірий", 2.5),
                new Car("BMW 5 Series", 2020, 35000, "Чорний", 3.0),
                new Car("Mercedes-Benz C-Class", 2021, 40000, "Білий", 2.0),
                new Car("Audi A6", 2018, 30000, "Сірий", 2.0),
                new Car("Honda Accord", 2022, 22000, "Синій", 2.4)
        );

        System.out.println("Завдання 3:");
        System.out.println("Список автомобілів: " + cars);

        System.out.print("Введіть колір: ");
        String userColor = scanner.next();
        List<Car> carsByColor = cars.stream()
                .filter(car -> car.color().equalsIgnoreCase(userColor))
                .toList();
        System.out.println("Автомобілі кольору " + userColor + ": " + carsByColor);

        System.out.print("Введіть об'єм двигуна: ");
        double userEngineVolume = scanner.nextDouble();
        List<Car> carsByEngineVolume = cars.stream()
                .filter(car -> car.engineVolume() == userEngineVolume)
                .toList();
        System.out.println("Автомобілі з об'ємом двигуна " + userEngineVolume + ": " + carsByEngineVolume);

        System.out.print("Введіть максимальну ціну: ");
        double maxPrice = scanner.nextDouble();
        List<Car> carsByMaxPrice = cars.stream()
                .filter(car -> car.price() > maxPrice)
                .toList();
        System.out.println("Автомобілі дорожчі за " + maxPrice + ": " + carsByMaxPrice);

        System.out.print("Введіть початковий рік: ");
        int startYear = scanner.nextInt();
        System.out.print("Введіть кінцевий рік: ");
        int endYear = scanner.nextInt();
        List<Car> carsByYearRange = cars.stream()
                .filter(car -> car.year() >= startYear && car.year() <= endYear)
                .toList();
        System.out.println("Автомобілі, рік випуску яких знаходиться в діапазоні " + startYear + " - " + endYear + ": " + carsByYearRange);
        System.out.println();

        // Завдання 4: Робота зі списком телевізорів
        List<Television> televisions = Arrays.asList(
                new Television("Samsung", 2021, 1000, 55, "Samsung Electronics"),
                new Television("LG OLED", 2022, 1500, 65, "LG Electronics"),
                new Television("Sony Bravia", 2020, 1200, 60, "Sony Corporation"),
                new Television("TCL", 2023, 800, 50, "TCL Corporation")
        );

        System.out.println("Завдання 4:");
        System.out.println("Список телевізорів: " + televisions);

        System.out.print("Введіть діагональ: ");
        double userDiagonal = scanner.nextDouble();
        List<Television> televisionsByDiagonal = televisions.stream()
                .filter(tv -> tv.diagonal() == userDiagonal)
                .toList();
        System.out.println("Телевізори з діагоналлю " + userDiagonal + ": " + televisionsByDiagonal);

        System.out.print("Введіть виробника: ");
        String userManufacturer = scanner.next();
        List<Television> televisionsByManufacturer = televisions.stream()
                .filter(tv -> tv.manufacturer().equalsIgnoreCase(userManufacturer))
                .toList();
        System.out.println("Телевізори виробника " + userManufacturer + ": " + televisionsByManufacturer);

        int currentYear = 2023;
        List<Television> currentYearTelevisions = televisions.stream()
                .filter(tv -> tv.year() == currentYear)
                .toList();
        System.out.println("Телевізори поточного року (" + currentYear + "): " + currentYearTelevisions);

        System.out.print("Введіть максимальну ціну: ");
        double maxTvPrice = scanner.nextDouble();
        List<Television> televisionsByMaxPrice = televisions.stream()
                .filter(tv -> tv.price() > maxTvPrice)
                .toList();
        System.out.println("Телевізори дорожчі за " + maxTvPrice + ": " + televisionsByMaxPrice);

        List<Television> televisionsByPriceAsc = televisions.stream()
                .sorted(Comparator.comparing(Television::price))
                .toList();
        System.out.println("Телевізори, відсортовані по ціні за зростанням: " + televisionsByPriceAsc);

        List<Television> televisionsByPriceDesc = televisions.stream()
                .sorted(Comparator.comparing(Television::price).reversed())
                .toList();
        System.out.println("Телевізори, відсортовані по ціні за спаданням: " + televisionsByPriceDesc);

        List<Television> televisionsByDiagonalAsc = televisions.stream()
                .sorted(Comparator.comparing(Television::diagonal))
                .toList();
        System.out.println("Телевізори, відсортовані по діагоналі за зростанням: " + televisionsByDiagonalAsc);

        List<Television> televisionsByDiagonalDesc = televisions.stream()
                .sorted(Comparator.comparing(Television::diagonal).reversed())
                .toList();
        System.out.println("Телевізори, відсортовані по діагоналі за спаданням: " + televisionsByDiagonalDesc);
    }
}
