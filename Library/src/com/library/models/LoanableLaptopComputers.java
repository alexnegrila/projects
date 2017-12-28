package com.library.models;

public class LoanableLaptopComputers {

    //Attributes that describe com.library.models.LoanableLaptopComputers
    private String name;
    private int windows;
    private int year;
    private String processor;
    private String availability;


    // Methods to set the values of the attributes and get them
    public void setLoanableLaptopComputers (String name, int windows, int year, String processor, String availability) {
        this.name=name;
        this.windows=windows;
        this.year=year;
        this.processor=processor;
        this.availability=availability;



    }

    public String getName() {
        return name;

    }



    public int GetWindows() {
        return windows;


    }


    public int getYear() {
        return year;

    }


    public String getProcessor() {
        return processor;
    }

    public String getAvailability() {
        return availability;

    }





}

