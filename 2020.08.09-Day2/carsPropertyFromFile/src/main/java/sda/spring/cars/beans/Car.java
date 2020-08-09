package sda.spring.cars.beans;

import sda.spring.cars.interfaces.FourWheeler;

public class Car implements FourWheeler {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void drive() {
        System.out.println("Medium sized, kinda jacky wheels.");
    }
}
