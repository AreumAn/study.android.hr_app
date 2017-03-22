package com.example.areum.myassignmentandroid;

/**
 * Created by areum on 2016-12-07.
 */

public class FullTime extends Employee {

    private int salary;
    private int bonus;

    public FullTime(){
        super();
        salary = 0;
        bonus = 0;
    }

    public FullTime(String pName, String pAge, String pCountry, int pSalary, int pBonus, Vehicle pV) {
        super(pName, pAge, pCountry, pV);
        this.salary =  pSalary;
        this.bonus = pBonus;
    }

    public FullTime(String pName, String pAge, String pCountry, int pSalary, int pBonus, String pMake, String pPlate) {
        super(pName, pAge, pCountry, pMake, pPlate);
        this.salary =  pSalary;
        this.bonus = pBonus;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int calcEarnings() {
        return (this.salary + this.bonus);
    }

    @Override
    public void displayData() {
        super.displayData();
        System.out.println("Salary : " + this.salary);
        System.out.println("Bonus : " + this.bonus);
    }

}
