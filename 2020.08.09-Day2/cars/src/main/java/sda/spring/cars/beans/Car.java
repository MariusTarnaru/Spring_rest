package sda.spring.cars.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sda.spring.cars.interfaces.FourWheeler;

@Component
public class Car implements FourWheeler {

    private String name;
    private Wheel wheel;

    @Autowired
    public Car(@Qualifier("supercarWheel") Wheel wheel) {
        this.wheel = wheel;
    }

    public Integer getWheelSize() {
        return wheel.getSize();
    }

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
