package com.example.areum.myassignmentandroid;

/**
 * Created by areum on 2016-12-07.
 */

public class Intern extends Employee {

    private String schoolName;

    public Intern(){
        super();
        schoolName = "";
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Intern(String pName, String pAge, String pCountry, String schoolName, Vehicle pV) {
        super(pName, pAge, pCountry, pV);
        this.schoolName = schoolName;
    }

    public Intern(String pName, String pAge, String pCountry, String schoolName, String pMake, String pPlate) {
        super(pName, pAge, pCountry, pMake, pPlate);
        this.schoolName = schoolName;
    }

    @Override
    public void displayData() {
        super.displayData();
        System.out.println("School : " + this.schoolName);
    }


}
