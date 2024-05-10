package com.ps;

import java.util.Scanner;

public class UserInterface {

    static Scanner scanner = new Scanner(System.in);

    public static void display(){

        System.out.println("Welcome to the World Famous Car Dealership Application!");
        System.out.println("How may we help you?");

        int mainMenuInput;

        do {
            System.out.println("Please select one of the following options:");
                System.out.println("(1) View Vehicles by Price");
                System.out.println("(2) View Vehicles by Make/Model");
                System.out.println("(3) View Vehicles by Year");
                System.out.println("(4) View Vehicles by Color");
                System.out.println("(5) View Vehicles by Mileage");
                System.out.println("(6) View Vehicles by Type");
                System.out.println("(7) View all Vehicles");
                System.out.println("(8) Add Vehicle");
                System.out.println("(9) Remove Vehicle");
                System.out.println("(0) Exit");

            mainMenuInput = scanner.nextInt();

            switch(mainMenuInput) {
                case 1:
                    // View Vehicles by Price
                        // Ask min/max
                    break;

                case 2:
                    // View Vehicles by Make/Model
                        // Ask make/model
                    break;

                case 3:
                    // View Vehicles by Year
                        // Ask min/max
                    break;

                case 4:
                    // View Vehicles by Color
                        // Ask color
                    break;

                case 5:
                    // View Vehicles by Mileage
                        // Ask min/max
                    break;

                case 6:
                    // View Vehicles by Type
                        // Ask Vehicle Type
                    break;

                case 7:
                    // View all Vehicles
                    break;

                case 8:
                    // Add Vehicle
                    break;

                case 9:
                    // Remove Vehicle
                    break;

                case 0:
                    // Exit
                    System.out.println("Exiting program");
                    break;

                default:
                    System.out.println("Not a command, try again");
                    break;
            }

        } while (mainMenuInput != 0);
    }
}
