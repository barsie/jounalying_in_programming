package Assignments.VehicleManagementSystem;

import java.util.Scanner;

public class Admin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vehicle Management System");
        System.out.println("1. Car\n2. Motorcycle\n3. Truck");
        System.out.print("Choose a vehicle type: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                Car car = new Car(make, model, year);
                System.out.print("Enter number of doors: ");
                car.setNumberOfDoors(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Enter fuel type (Petrol/Diesel/Hybrid/Electric): ");
                try {
                    car.setFuelType(scanner.nextLine());
                    displayCar(car);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 2:
                Motorcycle moto = new Motorcycle(make, model, year);
                System.out.print("Enter number of wheels: ");
                moto.setNumberOfWheels(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Enter motorcycle type: ");
                try {
                    moto.setTypeOfMotorcycle(scanner.nextLine());
                    displayMotorcycle(moto);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 3:
                Truck truck = new Truck(make, model, year);
                System.out.print("Enter cargo capacity (tons): ");
                truck.setCargoCapacity((int) scanner.nextDouble());
                scanner.nextLine();
                System.out.print("Enter transmission type (Manual/Automatic): ");
                try {
                    truck.setTransmissionType(scanner.nextLine());
                    displayTruck(truck);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    static void displayCar(Car car) {
        System.out.println("\n--- Car Details ---\n");
        System.out.printf(
            "Make: %s\nModel: %s\nYear: %d\nDoors: %d\nFuel: %s\n",
            car.Make(), car.Model(), car.manufacturingYear(),
            car.getNumberOfDoors(), car.getFuelType()
        );
    }

    static void displayMotorcycle(Motorcycle moto) {
        System.out.println("\n--- Motorcycle Details ---\n");
        System.out.printf(
            "Make: %s\nModel: %s\nYear: %d\nWheels: %d\nType: %s\n",
            moto.Make(), moto.Model(), moto.manufacturingYear(),
            moto.getNumberOfWheels(), moto.getTypeOfMotorcycle()
            ); 
    }

    static void displayTruck(Truck truck) {
        System.out.println("\n--- Truck Details ---\n");
        System.out.printf("Make: %s\nModel: %s\nYear: %d\nCargo Capacity: %.1f tons\nTransmission: %s\n",
                truck.Make(), truck.Model(), truck.manufacturingYear(),
                truck.getCargoCapacity(), truck.getTransmissionType());
    }
}

