package sda.testing.carrental.service;

import sda.testing.carrental.model.Car;

import java.util.List;

public interface Agency {

    List<Car> findCars(String brand);

    void cleanCar();
}
