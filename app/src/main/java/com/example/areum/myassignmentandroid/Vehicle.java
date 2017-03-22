package com.example.areum.myassignmentandroid;

/**
 * Created by areum on 2016-12-07.
 */

public class Vehicle implements IDisplayable {

    public String make;
    public String plate;

    public Vehicle(){
        super();
        make = "";
        plate = "";
    }

    public Vehicle(String make, String plate) {
        super();
        this.make = make;
        this.plate = plate;
    }

    @Override
    public void displayData() {
        System.out.println("Make : " + this.make);
        System.out.println("Plate : " + this.plate);

    }

}
