package sda.spring.cars.beans;

import org.springframework.stereotype.Component;

@Component
public class SmallWheel implements Wheel {

    Integer size = 3;

    @Override
    public Integer getSize() {
        return size;
    }

}
