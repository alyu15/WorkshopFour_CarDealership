package com.ps;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    public static void getDealership(ArrayList<Vehicle> inventory) {

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("inventory.txt"));

            String file;

            while((file = buffReader.readLine()) != null) {
                String[] splitFile = file.split("\\|");
                int vin = Integer.parseInt(splitFile[0]);
                int year = Integer.parseInt(splitFile[1]);
                String make = splitFile[2];
                String model = splitFile[3];
                String vehicleType = splitFile[4];
                String color = splitFile[5];
                int odometer = Integer.parseInt(splitFile[6]);
                double price = Double.parseDouble(splitFile[7]);

                Vehicle tempVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                inventory.add(tempVehicle);
            }
        } catch (IOException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void saveDealership(String path, String format) {

        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(path));

            buffWriter.write(format);
            buffWriter.close();

        } catch (IOException e) {
            System.out.println("Error writing to file!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
