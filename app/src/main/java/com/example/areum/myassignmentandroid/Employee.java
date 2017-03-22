package com.example.areum.myassignmentandroid;

/**
 * Created by areum on 2016-12-07.
 */

public class Employee implements IDisplayable {

    private String name;
    private String age;
    private String contry;
    Vehicle v = new Vehicle();

    public Employee(){
        name = "";
        age = "";
    }

    public Employee(String name, String age, String contry, Vehicle pV) {
        super();
        this.name = name;
        this.age = age;
        this.contry = contry;
        this.v = pV;
    }

    public Employee(String name, String age, String contry, String pPMake, String pPlate) {
        super();
        this.name = name;
        this.age = age;
        this.contry = contry;
        this.v.make = pPMake;
        this.v.plate = pPlate;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String pAge) {
        this.age = pAge;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public int calcBirthYear(int birthday){
        return (2016 - birthday);
    }

    public int calcEarnings() {
        return 1000;
    }


    @Override
    public void displayData() {

        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);

        v.displayData();

    }

}
