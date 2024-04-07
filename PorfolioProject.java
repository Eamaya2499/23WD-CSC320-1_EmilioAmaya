import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    public Automobile() {
    }

    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    public String listVehicleInformation() {
        return String.format("Make: %s\nModel: %s\nColor: %s\nYear: %d\nMileage: %d miles", make, model, color, year, mileage);
    }

    public void removeVehicle() {
        make = "";
        model = "";
        color = "";
        year = 0;
        mileage = 0;
    }

    public void updateVehicleAttributes(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }
}

public class PorfolioProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Automobile> automobiles = new ArrayList<>();

        try {
            boolean exit = false;
            while (!exit) {
                System.out.println("Choose an action:");
                System.out.println("1. Add a new vehicle");
                System.out.println("2. List vehicle information");
                System.out.println("3. Remove a vehicle");
                System.out.println("4. Update vehicle attributes");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.println("Enter make:");
                        String make = scanner.nextLine();
                        System.out.println("Enter model:");
                        String model = scanner.nextLine();
                        System.out.println("Enter color:");
                        String color = scanner.nextLine();
                        System.out.println("Enter year:");
                        int year = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.println("Enter mileage:");
                        int mileage = scanner.nextInt();
                        scanner.nextLine(); 
                        Automobile car = new Automobile(make, model, color, year, mileage);
                        automobiles.add(car);
                        System.out.println("Vehicle added successfully.");
                        break;
                    case 2:
                        System.out.println("Listing vehicle information:");
                        int vehicleCount = 0;
                        for (int i = 0; i < automobiles.size(); i++) {
                            if (!automobiles.get(i).listVehicleInformation().equals("")) {
                                System.out.println("Vehicle " + (++vehicleCount) + ":");
                                System.out.println(automobiles.get(i).listVehicleInformation());
                                System.out.println();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter index of vehicle to remove:");
                        int indexToRemove = scanner.nextInt();
                        scanner.nextLine(); 
                        if (indexToRemove >= 0 && indexToRemove < automobiles.size()) {
                            automobiles.get(indexToRemove).removeVehicle();
                            System.out.println("Vehicle removed successfully.");
                        } else {
                            System.out.println("Invalid index.");
                        }
                        break;
                    case 4:
                        System.out.println("Enter index of vehicle to update:");
                        int indexToUpdate = scanner.nextInt();
                        scanner.nextLine(); 
                        if (indexToUpdate >= 0 && indexToUpdate < automobiles.size()) {
                            System.out.println("Enter new make:");
                            make = scanner.nextLine();
                            System.out.println("Enter new model:");
                            model = scanner.nextLine();
                            System.out.println("Enter new color:");
                            color = scanner.nextLine();
                            System.out.println("Enter new year:");
                            year = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.println("Enter new mileage:");
                            mileage = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            automobiles.get(indexToUpdate).updateVehicleAttributes(make, model, color, year, mileage);
                            System.out.println("Vehicle attributes updated successfully.");
                        } else {
                            System.out.println("Invalid index.");
                        }
                        break;
                    case 5:
                        exit = true;
                        printToFile(automobiles);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void printToFile(List<Automobile> automobiles) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Do you want to print the information to a file? (Y/N)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                FileWriter writer = new FileWriter("C:\\Users\\Emili\\OneDrive\\Desktop");
                for (Automobile auto : automobiles) {
                    if (!auto.listVehicleInformation().equals("")) {
                        writer.write(auto.listVehicleInformation() + "\n\n");
                    }
                }
                writer.close();
                System.out.println("Information printed to file successfully.");
            } else if (response.equalsIgnoreCase("N")) {
                System.out.println("Information will not be printed to a file.");
            } else {
                System.out.println("Invalid input. Information will not be printed to a file.");
            }
        } catch (IOException e) {
            System.out.println("Error printing information to file: " + e.getMessage());
        }
    }
}
