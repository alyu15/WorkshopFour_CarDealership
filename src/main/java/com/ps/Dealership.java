package com.ps;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;

    ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void getVehiclesByPrice(){

    }
    public static void getVehiclesByMakeModel(){

    }
    public static void getVehiclesByYear(){

    }
    public static void getVehiclesByColor(){

    }
    public static void getVehiclesByMileage(){

    }
    public static void getVehiclesByType(){

    }
    public static void getAllVehicles(){

    }
    public static void addVehicle() {

    }
    public static void removeVehicle() {

    }

}
