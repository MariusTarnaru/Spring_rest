package sda.testing.carrental.service;

import org.springframework.stereotype.Service;
import sda.testing.carrental.model.Car;

import java.util.Collections;
import java.util.List;

@Service
public class OurAgency implements Agency {

    public List<Car> findCars(String brand) {
        return Collections.emptyList();
    }

    public void cleanCar() {

    }
}
