import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxDatabase {
    private final Map<String, Person> database;

    public TaxDatabase() {
        database = new HashMap<>();
    }

    public void printDatabase() {
        for (Person person : database.values()) {
            System.out.println(person);
        }
    }

    public void printDataByCode(String code) {
        Person person = database.get(code);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Person with code " + code + " not found.");
        }
    }

    public void printDataByPenaltyType(String penaltyType) {
        for (Person person : database.values()) {
            List<Penalty> penalties = person.getPenalties();
            for (Penalty penalty : penalties) {
                if (penalty.getType().equals(penaltyType)) {
                    System.out.println(person);
                    break;
                }
            }
        }
    }

    public void printDataByCity(String city) {
        for (Person person : database.values()) {
            if (person.getCity().equals(city)) {
                System.out.println(person);
            }
        }
    }

    public void addPerson(String code, String name, String city) {
        Person person = new Person(code, name, city);
        database.put(code, person);
    }

    public void addPenalty(String code, String penaltyType, int amount) {
        Person person = database.get(code);
        if (person != null) {
            Penalty penalty = new Penalty(penaltyType, amount);
            person.addPenalty(penalty);
        } else {
            System.out.println("Person with code " + code + " not found.");
        }
    }

    public void removePenalty(String code, String penaltyType) {
        Person person = database.get(code);
        if (person != null) {
            person.removePenalty(penaltyType);
        } else {
            System.out.println("Person with code " + code + " not found.");
        }
    }

    public void updatePersonInfo(String code, String newName, String newCity) {
        Person person = database.get(code);
        if (person != null) {
            person.setName(newName);
            person.setCity(newCity);
        } else {
            System.out.println("Person with code " + code + " not found.");
        }
    }

    public void updatePenaltyInfo(String code, String oldPenaltyType, String newPenaltyType, int newAmount) {
        Person person = database.get(code);
        if (person != null) {
            person.updatePenaltyInfo(oldPenaltyType, newPenaltyType, newAmount);
        } else {
            System.out.println("Person with code " + code + " not found.");
        }
    }

    public static void main(String[] args) {
        TaxDatabase taxDatabase = new TaxDatabase();

        // Додавання людей та штрафів
        taxDatabase.addPerson("111", "John Doe", "New York");
        taxDatabase.addPenalty("111", "Speeding", 100);
        taxDatabase.addPenalty("111", "Parking Violation", 50);

        taxDatabase.addPerson("222", "Jane Smith", "Los Angeles");
        taxDatabase.addPenalty("222", "Traffic Light Violation", 150);

        taxDatabase.addPerson("333", "Mike Johnson", "Chicago");
        taxDatabase.addPenalty("333", "Parking Violation", 75);
        taxDatabase.addPenalty("333", "Speeding", 120);

        // Виведення повної бази даних
        System.out.println("Full Database:");
        taxDatabase.printDatabase();
        System.out.println();

        // Виведення даних по конкретному коду
        System.out.println("Data for code 111:");
        taxDatabase.printDataByCode("111");
        System.out.println();

        // Виведення даних по конкретному типу штрафу
        System.out.println("Data for penalty type 'Parking Violation':");
        taxDatabase.printDataByPenaltyType("Parking Violation");
        System.out.println();

        // Виведення даних по конкретному місту
        System.out.println("Data for city 'Chicago':");
        taxDatabase.printDataByCity("Chicago");
        System.out.println();

        // Додавання нової людини
        taxDatabase.addPerson("444", "Sarah Brown", "Boston");

        // Додавання нових штрафів для існуючого запису
        taxDatabase.addPenalty("444", "Parking Violation", 80);
        taxDatabase.addPenalty("444", "Speeding", 90);

        // Видалення штрафу
        taxDatabase.removePenalty("444", "Parking Violation");

        // Заміна інформації про людину та її штрафи
        taxDatabase.updatePersonInfo("444", "Sarah Green", "Boston");
        taxDatabase.updatePenaltyInfo("444", "Speeding", "Traffic Light Violation", 120);

        // Виведення оновленої бази даних
        System.out.println("Updated Database:");
        taxDatabase.printDatabase();
    }
}

class Person {
    private final String code;
    private String name;
    private String city;
    private final List<Penalty> penalties;

    public Person(String code, String name, String city) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.penalties = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Penalty> getPenalties() {
        return penalties;
    }

    public void addPenalty(Penalty penalty) {
        penalties.add(penalty);
    }

    public void removePenalty(String penaltyType) {
        penalties.removeIf(penalty -> penalty.getType().equals(penaltyType));
    }

    public void updatePenaltyInfo(String oldPenaltyType, String newPenaltyType, int newAmount) {
        for (Penalty penalty : penalties) {
            if (penalty.getType().equals(oldPenaltyType)) {
                penalty.setType(newPenaltyType);
                penalty.setAmount(newAmount);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Code: ").append(code).append(", ");
        sb.append("Name: ").append(name).append(", ");
        sb.append("City: ").append(city).append(", ");
        sb.append("Penalties: ");
        if (penalties.isEmpty()) {
            sb.append("None");
        } else {
            for (Penalty penalty : penalties) {
                sb.append(penalty).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()); // Remove the trailing comma and space
        }
        return sb.toString();
    }
}

class Penalty {
    private String type;
    private int amount;

    public Penalty(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + " ($" + amount + ")";
    }
}
