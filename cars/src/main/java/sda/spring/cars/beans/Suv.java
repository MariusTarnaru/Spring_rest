package sda.spring.cars.beans;

import sda.spring.cars.interfaces.FourWheeler;

public class Suv implements FourWheeler {
    @Override
    public void drive() {
        System.out.println("Big wheels!");
    }
}
