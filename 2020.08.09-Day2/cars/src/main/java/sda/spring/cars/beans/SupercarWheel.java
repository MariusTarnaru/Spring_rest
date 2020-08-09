package sda.spring.cars.beans;

import org.springframework.stereotype.Component;

@Component
public class SupercarWheel implements Wheel {
    @Override
    public Integer getSize() {
        return 15;
    }
}
