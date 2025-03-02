public class Main {
    public static void main(String[] args) {
        Car[] cars = {
                new Car("Toyota", "Corolla", 2022),
                new ElectricCar("Tesla", "Model S", 2023, 400),
                new Car("TATA", "Nano", 2008)
        };

        for (Car car : cars) {
            car.startEngine(); // Demonstrates polymorphism
        }
    }
}
