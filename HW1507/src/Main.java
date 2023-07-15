import java.util.*;

// Клас "Продукт"
record Product(String name, String category) {

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

// Клас "Пристрій"
record Device(String name, int year, double price, String color, String type) {

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

// Клас "Проектор"
record Projector(String name, int year, double price, String manufacturer) {

    @Override
    public String toString() {
        return "Projector{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Завдання 1: Робота зі списком цілих чисел
        List<Integer> numbers = new Random().ints(20, -99, 100)
                .boxed()
                .toList();

        System.out.println("Завдання 1:");
        System.out.println("Список чисел: " + numbers);

        long countPositive = numbers.stream()
                .filter(n -> n > 0)
                .count();
        System.out.println("Кількість додатних чисел: " + countPositive);

        long countNegative = numbers.stream()
                .filter(n -> n < 0)
                .count();
        System.out.println("Кількість від'ємних чисел: " + countNegative);

        long countTwoDigit = numbers.stream()
                .filter(n -> n >= -99 && n <= -10 || n >= 10 && n <= 99)
                .count();
        System.out.println("Кількість двозначних чисел: " + countTwoDigit);

        long countMirrorNumbers = numbers.stream()
                .filter(n -> {
                    String numberString = String.valueOf(n);
                    String reversedNumberString = new StringBuilder(numberString).reverse().toString();
                    return numberString.equals(reversedNumberString);
                })
                .count();
        System.out.println("Кількість дзеркальних чисел: " + countMirrorNumbers);
        System.out.println();

        // Завдання 2: Робота зі списком продуктів
        List<Product> products = List.of(
                new Product("Яблуко", "Фрукти"),
                new Product("Банан", "Фрукти"),
                new Product("Груша", "Фрукти"),
                new Product("Молоко", "Молочні продукти"),
                new Product("Масло", "Молочні продукти"),
                new Product("Сир", "Молочні продукти"),
                new Product("Молоко", "Молочні продукти")
        );

        System.out.println("Завдання 2:");
        System.out.println("Список продуктів: " + products);

        List<Product> shortProducts = products.stream()
                .filter(p -> p.name().length() < 5)
                .toList();
        System.out.println("Продукти з назвою менше п'яти символів: " + shortProducts);

        System.out.print("Введіть назву продукту: ");
        String userProduct = scanner.next();
        long countUserProduct = products.stream()
                .filter(p -> p.name().equalsIgnoreCase(userProduct))
                .count();
        System.out.println("Кількість згадувань продукту " + userProduct + ": " + countUserProduct);

        System.out.print("Введіть літеру: ");
        String letter = scanner.next();
        List<Product> productsByLetter = products.stream()
                .filter(p -> p.name().startsWith(letter.toUpperCase()))
                .toList();
        System.out.println("Продукти, що починаються на літеру " + letter + ": " + productsByLetter);

        System.out.print("Введіть категорію продукту: ");
        String userCategory = scanner.next();
        List<Product> productsByCategory = products.stream()
                .filter(p -> p.category().equalsIgnoreCase(userCategory))
                .toList();
        System.out.println("Продукти з категорії '" + userCategory + "': " + productsByCategory);

        // Завдання 3: Робота зі списком пристроїв
        List<Device> devices = Arrays.asList(
                new Device("Телефон", 2021, 1000, "Чорний", "Смартфон"),
                new Device("Ноутбук", 2020, 1500, "Сріблястий", "Лаптоп"),
                new Device("Телевізор", 2019, 2000, "Чорний", "ТВ"),
                new Device("Планшет", 2022, 800, "Білий", "Таблетка"),
                new Device("Смартгодинник", 2023, 200, "Чорний", "Годинник")
        );

        System.out.println("Завдання 3:");
        System.out.println("Список пристроїв: " + devices);

        System.out.print("Введіть колір: ");
        String userColor = scanner.next();
        List<Device> devicesByColor = devices.stream()
                .filter(d -> d.color().equalsIgnoreCase(userColor))
                .toList();
        System.out.println("Пристрої кольору " + userColor + ": " + devicesByColor);

        System.out.print("Введіть рік випуску: ");
        int userYear = scanner.nextInt();
        List<Device> devicesByYear = devices.stream()
                .filter(d -> d.year() == userYear)
                .toList();
        System.out.println("Пристрої випущені в " + userYear + " році: " + devicesByYear);

        System.out.print("Введіть максимальну ціну: ");
        double maxDevicePrice = scanner.nextDouble();
        List<Device> devicesByMaxPrice = devices.stream()
                .filter(d -> d.price() > maxDevicePrice)
                .toList();
        System.out.println("Пристрої дорожчі за " + maxDevicePrice + ": " + devicesByMaxPrice);

        System.out.print("Введіть тип пристрою: ");
        String userType = scanner.next();
        List<Device> devicesByType = devices.stream()
                .filter(d -> d.type().equalsIgnoreCase(userType))
                .toList();
        System.out.println("Пристрої типу " + userType + ": " + devicesByType);

        System.out.print("Введіть початковий рік: ");
        int startDeviceYear = scanner.nextInt();
        System.out.print("Введіть кінцевий рік: ");
        int endDeviceYear = scanner.nextInt();
        List<Device> devicesByYearRange = devices.stream()
                .filter(d -> d.year() >= startDeviceYear && d.year() <= endDeviceYear)
                .toList();
        System.out.println("Пристрої, рік випуску яких входить в діапазон " + startDeviceYear + " - " + endDeviceYear + ": " + devicesByYearRange);
        System.out.println();

        // Завдання 4: Робота зі списком проекторів
        List<Projector> projectors = Arrays.asList(
                new Projector("Epson", 2021, 1500, "Seiko Epson Corporation"),
                new Projector("BenQ", 2022, 1200, "BenQ Corporation"),
                new Projector("Sony", 2020, 1800, "Sony Corporation"),
                new Projector("Optoma", 2023, 1000, "Optoma Corporation")
        );

        System.out.println("Завдання 4:");
        System.out.println("Список проекторів: " + projectors);

        System.out.print("Введіть виробника: ");
        String userManufacturer = scanner.next();
        List<Projector> projectorsByManufacturer = projectors.stream()
                .filter(p -> p.manufacturer().equalsIgnoreCase(userManufacturer))
                .toList();
        System.out.println("Проектори виробника " + userManufacturer + ": " + projectorsByManufacturer);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Projector> currentYearProjectors = projectors.stream()
                .filter(p -> p.year() == currentYear)
                .toList();
        System.out.println("Проектори поточного року (" + currentYear + "): " + currentYearProjectors);

        System.out.print("Введіть максимальну ціну: ");
        double maxProjectorPrice = scanner.nextDouble();
        List<Projector> projectorsByMaxPrice = projectors.stream()
                .filter(p -> p.price() > maxProjectorPrice)
                .toList();
        System.out.println("Проектори дорожчі за " + maxProjectorPrice + ": " + projectorsByMaxPrice);

        List<Projector> projectorsByPriceAsc = projectors.stream()
                .sorted(Comparator.comparing(Projector::price))
                .toList();
        System.out.println("Проектори, відсортовані по ціні за зростанням: " + projectorsByPriceAsc);

        List<Projector> projectorsByPriceDesc = projectors.stream()
                .sorted(Comparator.comparing(Projector::price).reversed())
                .toList();
        System.out.println("Проектори, відсортовані по ціні за спаданням: " + projectorsByPriceDesc);

        List<Projector> projectorsByYearAsc = projectors.stream()
                .sorted(Comparator.comparing(Projector::year))
                .toList();
        System.out.println("Проектори, відсортовані по року випуску за зростанням: " + projectorsByYearAsc);

        List<Projector> projectorsByYearDesc = projectors.stream()
                .sorted(Comparator.comparing(Projector::year).reversed())
                .toList();
        System.out.println("Проектори, відсортовані по року випуску за спаданням: " + projectorsByYearDesc);
    }
}
