package com.ps;

import java.sql.SQLOutput;
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
                    handleViewVehiclesByPrice();
                    break;

                case "2":
                    handleViewVehiclesByMakeModel();
                    break;

                case "3":
                    handleViewVehiclesByYear();
                    break;

                case "4":
                    handleViewVehiclesByColor();
                    break;

                case "5":
                    handleViewVehiclesByMileage();
                    break;

                case "6":
                    handleViewVehiclesByType();
                    break;

                case "7":
                    handleViewAllVehicles();
                    break;

                case "8":
                    handleAddVehicle();
                    break;

                case "9":
                    handleRemoveVehicle();
                    break;

                case "0":
                    System.out.println("********************  Exiting program... ********************");
                    System.out.println("                   --  Have a nice day!  --");
                    break;

                default:
                    System.out.println("********************* Command not found *********************");
                    System.out.println("                    -- Please try again --");
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

    public static void handleViewVehiclesByPrice() {

        System.out.println("\n******************************** View Vehicles By Price ********************************");
        System.out.println("\n* Please enter in the minimum price of the vehicle you are searching for:");
            double minPrice = scanner.nextDouble();

        System.out.println("* Please enter in the maximum price of the vehicle you are searching for:");
            double maxPrice = scanner.nextDouble();

        ArrayList<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehiclesByPrice);
    }

    public static void handleViewVehiclesByMakeModel() {

        System.out.println("\n******************************** View Vehicles By Make/Model ********************************");
        System.out.println("\n* Please enter in the make of the vehicle you are searching for:");
            String make = scanner.next();

        System.out.println("* Please enter in the model of the vehicle you are searching for:");
            String model = scanner.next();

        ArrayList<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehiclesByMakeModel);

    }

    public static void handleViewVehiclesByYear() {

        System.out.println("\n================================= View Vehicles By Year =================================");
        System.out.println("\n* Please enter in the minimum year of the vehicle you are searching for:");
            int minYear = scanner.nextInt();

        System.out.println("* Please enter in the maximum year of the vehicle you are searching for:");
            int maxYear = scanner.nextInt();

        ArrayList<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehiclesByYear);
    }

    public static void handleViewVehiclesByColor() {

        System.out.println("\n================================= View Vehicles By Color =================================");
        System.out.println("* Please enter in the color of the vehicle you are searching for:");
            String color = scanner.next();

        ArrayList<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
        displayVehicles(vehiclesByColor);
    }

    public static void handleViewVehiclesByMileage() {

        System.out.println("\n================================= View Vehicles By Mileage =================================");
        System.out.println("\n* Please enter in the minimum mileage of the vehicle you are searching for:");
            int minMileage = scanner.nextInt();

        System.out.println("* Please enter in the maximum mileage of the vehicle you are searching for:");
            int maxMileage = scanner.nextInt();

        ArrayList<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehiclesByMileage);
    }

    public static void handleViewVehiclesByType() {

        System.out.println("\n================================= View Vehicles By Vehicle Type =================================");
        System.out.println("\n* Please enter in the type of the vehicle you are searching for:");
            String vehicleType = scanner.next();

        ArrayList<Vehicle> vehiclesByType = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehiclesByType);
    }

    public static void handleViewAllVehicles() {

        System.out.println("\n====================================== View All Vehicles ======================================");
        displayVehicles(dealership.getAllVehicles());
    }

    public static void handleAddVehicle() {

        System.out.println("\n====================================== Add a Vehicle ======================================");

        System.out.println("\n* Please enter in the VIN of the vehicle:");
            int newVehicleVin;
            while(true) {
                if (scanner.hasNextInt()) {
                    newVehicleVin = scanner.nextInt();
                    break;
                } else {
                    System.out.println("* Please enter in a number.");
                    scanner.next();
                }
            }

        System.out.println("* Please enter in the Year of the vehicle:");
            int newVehicleYear;
            while(true) {
                if (scanner.hasNextInt()) {
                    newVehicleYear = scanner.nextInt();
                    break;
                } else {
                    System.out.println("* Please enter in a number.");
                    scanner.next();
                }
            }

        System.out.println("* Please enter in the Make of the vehicle:");
            String newVehicleMake;
            while (true) {
                newVehicleMake = scanner.next().trim();
                if (newVehicleMake.matches(".*\\d.*") || newVehicleMake.isEmpty()) {
                    System.out.println("* Please enter a non-empty value with no numbers.");
                } else {
                    break;
                }
            }

        String newVehicleMakeEntry = newVehicleMake.substring(0, 1).toUpperCase() + newVehicleMake.substring(1);

        System.out.println("* Please enter in the Model of the vehicle:");
            String newVehicleModel;
            while (true) {
                newVehicleModel = scanner.next().trim();
                if (newVehicleModel.matches(".*\\d.*") || newVehicleModel.isEmpty()) {
                    System.out.println("* Please enter a non-empty value with no numbers.");
                } else {
                    break;
                }
            }
            String newVehicleModelEntry = newVehicleModel.substring(0,1).toUpperCase() + newVehicleModel.substring(1);

        System.out.println("* Please enter in the Type of the vehicle:");
            String newVehicleType;
            while (true) {
                newVehicleType = scanner.next().trim();
                if (newVehicleType.matches(".*\\d.*") || newVehicleType.isEmpty()) {
                    System.out.println("* Please enter a non-empty value with no numbers.");
                } else {
                    break;
                }
            }
            String newVehicleTypeEntry = newVehicleType.substring(0,1).toUpperCase() + newVehicleType.substring(1);

        System.out.println("* Please enter in the Color of the vehicle:");
            String newVehicleColor;
            while (true) {
                newVehicleColor = scanner.next().trim();
                if (newVehicleColor.matches(".*\\d.*") || newVehicleColor.isEmpty()) {
                    System.out.println("* Please enter a non-empty value with no numbers.");
                } else {
                    break;
                }
            }
            String newVehicleColorEntry = newVehicleColor.substring(0,1).toUpperCase() + newVehicleColor.substring(1);

        System.out.println("* Please enter in the Mileage of the vehicle:");
            int newVehicleMileage;
            while(true) {
                if (scanner.hasNextInt()) {
                    newVehicleMileage = scanner.nextInt();
                    break;
                } else {
                    System.out.println("* Please enter in a number.");
                    scanner.next();
                }
            }

        System.out.println("* Please enter in the Price of the vehicle:");
            double newVehiclePrice;
            while(true) {
                if (scanner.hasNextDouble()) {
                    newVehiclePrice = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("* Please enter in a number.");
                    scanner.next();
                }
            }

        Vehicle newVehicle = new Vehicle(newVehicleVin, newVehicleYear, newVehicleMakeEntry, newVehicleModelEntry,
                newVehicleTypeEntry, newVehicleColorEntry, newVehicleMileage, newVehiclePrice);

        dealership.addVehicle(newVehicle);

        DealershipFileManager.saveDealership(dealership);
        System.out.println("\n************************** You have successfully added a new vehicle! ***************************");
    }

    public static void handleRemoveVehicle() {

        System.out.println("\n====================================== Remove a Vehicle ======================================");

    }

}
