package sda.spring.cars.beans;

import org.springframework.stereotype.Component;
import sda.spring.cars.interfaces.FourWheeler;

@Component
public class ShoppingCart implements FourWheeler {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void drive() {
        System.out.println("Driving in Lidl");
    }
}
