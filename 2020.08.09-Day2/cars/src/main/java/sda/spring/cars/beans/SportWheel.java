package sda.spring.cars.beans;

import org.springframework.stereotype.Component;

@Component
public class SportWheel implements Wheel {
    Integer size = 17;

    @Override
    public Integer getSize() {
        return size;
    }

}
