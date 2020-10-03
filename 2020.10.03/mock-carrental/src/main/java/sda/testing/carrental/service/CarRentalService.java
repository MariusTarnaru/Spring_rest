package sda.testing.carrental.service;

import org.springframework.stereotype.Service;
import sda.testing.carrental.model.Car;
import sda.testing.carrental.service.exception.NotClientException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarRentalService {

    private List<Agency> agencyList;
    private ClientService clientService;

    public CarRentalService(List<Agency> agencyList, ClientService clientService) {
        this.agencyList = agencyList;
        this.clientService = clientService;
    }

    public List<Car> findByBrand(String brand) {
        if (!clientService.isClient()) {
            throw new NotClientException();
        }
        List<Car> foundCars = new ArrayList<>();

        for (Agency agency : agencyList) {
            foundCars.addAll(agency.findCars(brand));
        }

        return foundCars;
    }

    public void cleanCars() {
        for (Agency agency : agencyList) {
            agency.cleanCar();
        }

    }

}
