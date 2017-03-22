package com.example.areum.myassignmentandroid;

/**
 * Created by areum on 2016-12-07.
 */

public class PartTime extends Employee {

    private int hoursWorked;
    private int rate;

    public PartTime(){
        super();
        hoursWorked = 0;
        rate = 0;
    }

    public PartTime(String pName, String pAge, String pCountry, int hoursWorked, int rate, Vehicle pV) {
        super(pName, pAge, pCountry, pV);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    public PartTime(String pName, String pAge, String pCountry, int hoursWorked, int rate, String pMake, String pPlate) {
        super(pName, pAge, pCountry, pMake, pPlate);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public int calcEarnings() {
        return (this.hoursWorked * this.rate);
    }

    @Override
    public void displayData() {
        super.displayData();

        System.out.println("Rate : " + this.rate);
        System.out.println("Hours : " + this.hoursWorked);
    }



}
