package com.ps;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    static Scanner scanner = new Scanner(System.in);
    private static Dealership dealership;

    private static void init(){

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }
    public static void display(){

        init();

        System.out.println("\n******************** Welcome to the World Famous Car Dealership Application! ********************");
        System.out.println("                             --  How may we help you?  --");
        System.out.println("*************************************************************************************************");

        handleMainMenu();
    }
    public static void handleMainMenu() {

        String mainMenuInput;

        do {
            System.out.println("\n=================================================================================================");
            System.out.println("* Please select one of the following options:\n");
                System.out.println("~ (1) View Vehicles by Price");
                System.out.println("~ (2) View Vehicles by Make/Model");
                System.out.println("~ (3) View Vehicles by Year");
                System.out.println("~ (4) View Vehicles by Color");
                System.out.println("~ (5) View Vehicles by Mileage");
                System.out.println("~ (6) View Vehicles by Type");
                System.out.println("~ (7) View all Vehicles\n");
                System.out.println("~ (8) Add Vehicle");
                System.out.println("~ (9) Remove Vehicle");
                System.out.println("~ (0) Exit");

            mainMenuInput = scanner.next();

            switch(mainMenuInput) {
                case "1":
                    // View Vehicles by Price
                    // Ask min/max
                    System.out.println("\n******************************** View Vehicles By Price ********************************");
                    System.out.println("\n* Please enter in the minimum price of the vehicle you are searching for:");
                        double minPrice = scanner.nextDouble();

                    System.out.println("* Please enter in the maximum price of the vehicle you are searching for:");
                        double maxPrice = scanner.nextDouble();

                    ArrayList<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice);
                    displayVehicles(vehiclesByPrice);
                    break;

                case "2":
                    // View Vehicles by Make/Model
                    // Ask make/model
                    System.out.println("\n******************************** View Vehicles By Make/Model ********************************");
                    System.out.println("\n* Please enter in the make of the vehicle you are searching for:");
                        String make = scanner.next();

                    System.out.println("* Please enter in the model of the vehicle you are searching for:");
                        String model = scanner.next();

                    ArrayList<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);
                    displayVehicles(vehiclesByMakeModel);
                    break;

                case "3":
                    // View Vehicles by Year
                    // Ask min/max
                    System.out.println("\n================================= View Vehicles By Year =================================");
                    System.out.println("\n* Please enter in the minimum year of the vehicle you are searching for:");
                        int minYear = scanner.nextInt();

                    System.out.println("* Please enter in the maximum year of the vehicle you are searching for:");
                        int maxYear = scanner.nextInt();

                    ArrayList<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(minYear, maxYear);
                    displayVehicles(vehiclesByYear);
                    break;

                case "4":
                    // View Vehicles by Color
                    // Ask color
                    System.out.println("\n================================= View Vehicles By Color =================================");
                    System.out.println("* Please enter in the color of the vehicle you are searching for:");
                        String color = scanner.next();

                    ArrayList<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
                    displayVehicles(vehiclesByColor);
                    break;

                case "5":
                    // View Vehicles by Mileage
                    // Ask min/max
                    System.out.println("\n================================= View Vehicles By Mileage =================================");
                    System.out.println("\n* Please enter in the minimum mileage of the vehicle you are searching for:");
                        int minMileage = scanner.nextInt();

                    System.out.println("* Please enter in the maximum mileage of the vehicle you are searching for:");
                        int maxMileage = scanner.nextInt();

                    ArrayList<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(minMileage, maxMileage);
                    displayVehicles(vehiclesByMileage);
                    break;

                case "6":
                    // View Vehicles by Type
                    // Ask Vehicle Type
                    System.out.println("\n================================= View Vehicles By Vehicle Type =================================");
                    System.out.println("\n* Please enter in the type of the vehicle you are searching for:");
                        String vehicleType = scanner.next();

                    ArrayList<Vehicle> vehiclesByType = dealership.getVehiclesByType(vehicleType);
                    displayVehicles(vehiclesByType);
                    break;

                case "7":
                    // View all Vehicles
                    ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
                    displayVehicles(dealership.getAllVehicles());
                    break;

                case "8":
                    // Add Vehicle
                    break;

                case "9":
                    // Remove Vehicle
                    break;

                case "0":
                    // Exit
                    System.out.println("********************  Exiting program... ********************");
                    System.out.println("                   --  Have a nice day!  --");
                    break;

                default:
                    System.out.println("       ** Command not found **");
                    System.out.println("        - Please try again -");
                    break;
            }

        } while (!mainMenuInput.equals("0"));
    }

    private static void displayVehicles(ArrayList<Vehicle> vehicles) {
        for(Vehicle vehicle: vehicles) {
            System.out.println(vehicle);
        }
        if(vehicles.isEmpty()) {
            System.out.println("\n********************* No vehicles found **********************");
        }
    }

    private static void processAllVehiclesRequest() {
        // Takes in user input

    }

}
