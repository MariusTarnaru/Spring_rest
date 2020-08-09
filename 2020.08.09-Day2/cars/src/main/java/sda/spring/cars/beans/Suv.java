package sda.spring.cars.beans;

import org.springframework.stereotype.Component;
import sda.spring.cars.interfaces.FourWheeler;

@Component
public class Suv implements FourWheeler {
    @Override
    public void drive() {
        System.out.println("Big wheels!");
    }
}
