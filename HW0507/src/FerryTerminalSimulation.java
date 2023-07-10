import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FerryTerminalSimulation {
    private static final int MAX_CAPACITY = 100; // Максимальна кількість людей на зупинці

    public static void main(String[] args) {
        Stop stop = new Stop();
        Ferry ferry = new Ferry();

        // Введення середнього часу між приходом пасажирів та катерів
        double avgPassengerArrivalTime = inputAverageTime("Passenger arrival time");
        double avgFerryArrivalTime = inputAverageTime("Ferry arrival time");

        // Введення типу зупинки катера (кінцева чи ні)
        boolean isTerminalEndpoint = inputTerminalType();

        // Симуляція приходу пасажирів та катерів протягом дня
        simulateDay(stop, ferry, avgPassengerArrivalTime, avgFerryArrivalTime, isTerminalEndpoint);

        // Розрахунок середнього часу перебування людини на зупинці
        double avgStayTime = stop.calculateAverageStayTime();
        System.out.println("Average stay time: " + avgStayTime);

        // Перевірка допустимого часового інтервалу між катерами
        boolean isIntervalValid = stop.checkTimeInterval(avgFerryArrivalTime, MAX_CAPACITY);
        System.out.println("Is interval valid: " + isIntervalValid);

        // Генерація випадкової кількості вільних місць в катері
        int freeSeats = ferry.generateRandomFreeSeats();
        System.out.println("Free seats in the ferry: " + freeSeats);
    }

    private static double inputAverageTime(String timeName) {
        // Логіка вводу середнього часу між появою пасажирів та катерів
        // Повертає введений користувачем середній час
        return 0.0;
    }

    private static boolean inputTerminalType() {
        // Логіка вводу типу зупинки катера (кінцева чи ні)
        // Повертає введене користувачем значення типу зупинки (true або false)
        return false;
    }

    private static void simulateDay(Stop stop, Ferry ferry, double avgPassengerArrivalTime, double avgFerryArrivalTime, boolean isTerminalEndpoint) {
        Random random = new Random();
        int totalMinutes = 24 * 60; // Кількість хвилин у дні
        int currentMinute = 0;

        while (currentMinute < totalMinutes) {
            // Пасажири приходять на зупинку
            if (random.nextDouble() < (1.0 / avgPassengerArrivalTime)) {
                Passenger passenger = new Passenger(LocalDateTime.now());
                stop.addPassenger(passenger);
            }

            // Катер приходить на зупинку
            if (random.nextDouble() < (1.0 / avgFerryArrivalTime)) {
                int freeSeats = ferry.generateRandomFreeSeats();
                FerryArrivalType arrivalType = isTerminalEndpoint ? FerryArrivalType.ENDPOINT : FerryArrivalType.NORMAL;
                FerryArrival ferryArrival = new FerryArrival(LocalDateTime.now(), arrivalType, freeSeats);
                ferry.addFerryArrival(ferryArrival);
            }

            // Посадка пасажирів на катер
            ferry.loadPassengers(stop, 5); // Максимально 5 пасажирів на зупинці одночасно

            // Відправка катера
            ferry.depart();

            // Оновлення часу
            currentMinute += 10; // Припустимо, що кожна ітерація циклу триває 10 хвилин
        }
    }

    private static class Stop {
        private List<Passenger> passengers;

        public Stop() {
            passengers = new ArrayList<>();
        }

        public void addPassenger(Passenger passenger) {
            passengers.add(passenger);
        }

        public void removePassengers(List<Passenger> passengersToRemove) {
            passengers.removeAll(passengersToRemove);
        }

        public List<Passenger> getPassengers() {
            return passengers;
        }

        public double calculateAverageStayTime() {
            // Логіка розрахунку середнього часу перебування людини на зупинці
            // Повертає обчислений середній час перебування
            return 0.0;
        }

        public boolean checkTimeInterval(double ferryArrivalTime, int maxCapacity) {
            // Логіка перевірки допустимого часового інтервалу між катерами
            // Повертає true, якщо інтервал є допустимим,
            // або false в іншому випадку
            return false;
        }

        // Додаткові методи, які можуть знадобитися
    }

    private static class Ferry {
        private List<FerryArrival> ferryArrivals;
        private int freeSeats;

        public Ferry() {
            ferryArrivals = new ArrayList<>();
            freeSeats = 0;
        }

        public void addFerryArrival(FerryArrival ferryArrival) {
            ferryArrivals.add(ferryArrival);
        }

        public void loadPassengers(Stop stop, int maxPassengers) {
            for (FerryArrival arrival : ferryArrivals) {
                if (arrival.getFreeSeats() > 0) {
                    List<Passenger> passengersToLoad = new ArrayList<>();
                    for (Passenger passenger : stop.getPassengers()) {
                        if (passengersToLoad.size() == maxPassengers) {
                            break;
                        }
                        passengersToLoad.add(passenger);
                    }
                    stop.removePassengers(passengersToLoad);
                    arrival.loadPassengers(passengersToLoad);
                }
            }
        }

        public void depart() {
            for (FerryArrival arrival : ferryArrivals) {
                if (arrival.getPassengers().size() > 0) {
                    System.out.println("Ferry departure at: " + arrival.getArrivalTime());
                    System.out.println("Number of passengers on board: " + arrival.getPassengers().size());
                    System.out.println("Destination: " + arrival.getArrivalType());
                    arrival.clearPassengers();
                }
            }
        }

        public int generateRandomFreeSeats() {
            Random random = new Random();
            return random.nextInt(11) + 10; // Випадкова кількість місць від 10 до 20
        }

        // Додаткові методи, які можуть знадобитися
    }
}

enum FerryArrivalType {
    NORMAL, ENDPOINT
}

class Passenger {
    private LocalDateTime arrivalTime;

    public Passenger(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    // Геттери та сеттери, які можуть знадобитися
}

class FerryArrival {
    private LocalDateTime arrivalTime;
    private FerryArrivalType arrivalType;
    private int freeSeats;
    private List<Passenger> passengers;

    public FerryArrival(LocalDateTime arrivalTime, FerryArrivalType arrivalType, int freeSeats) {
        this.arrivalTime = arrivalTime;
        this.arrivalType = arrivalType;
        this.freeSeats = freeSeats;
        this.passengers = new ArrayList<>();
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public FerryArrivalType getArrivalType() {
        return arrivalType;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void loadPassengers(List<Passenger> passengersToLoad) {
        passengers.addAll(passengersToLoad);
        freeSeats -= passengersToLoad.size();
    }

    public void clearPassengers() {
        passengers.clear();
    }
}
