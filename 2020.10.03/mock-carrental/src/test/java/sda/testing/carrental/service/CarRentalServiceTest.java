package sda.testing.carrental.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sda.testing.carrental.model.Car;
import sda.testing.carrental.service.exception.NotClientException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarRentalServiceTest {
    @Mock private Agency firstAgency;
    @Mock private Agency secondAgency;
    @Mock ClientService clientService;
    private CarRentalService carRentalService;

    private static final String BRAND = "Toyota";

    @BeforeEach
    void init() {
        carRentalService = new CarRentalService(Arrays.asList(firstAgency, secondAgency), clientService);
    }

    @Test
    void shouldReturnCarsFromAgenciesWhenFindByBrand() {
        ArrayList<Car> cars = buildCars();
        when(firstAgency.findCars(BRAND)).thenReturn(Collections.<Car>emptyList());
        when(secondAgency.findCars(BRAND)).thenReturn(cars);
        when(clientService.isClient()).thenReturn(true);

        List<Car> actualCars = carRentalService.findByBrand(BRAND);

        assertEquals(1, actualCars.size());
        assertThat(actualCars).usingFieldByFieldElementComparator().containsExactlyElementsOf(cars);
    }

    private ArrayList<Car> buildCars() {
        ArrayList<Car> cars = new ArrayList<Car>();
        Car toyota = new Car()
                .setBrand("Toyota")
                .setModel("Yaris")
                .setYear(2015)
                .setPrice(20000f);
        cars.add(toyota);
        return cars;
    }

    @Test
    void shouldTellAllAgenciesToCleanTheirCars() {
        carRentalService.cleanCars();

        verify(firstAgency).cleanCar();
        verify(secondAgency).cleanCar();
        verifyNoMoreInteractions(firstAgency, secondAgency);
    }

    @Test
    void shouldThrowNotClientExceptionWhenUserIsNotOurClient() {
        when(clientService.isClient()).thenReturn(false);

        assertThrows(NotClientException.class, () -> carRentalService.findByBrand("Toyota"));
        verifyNoInteractions(firstAgency, secondAgency);
        verify(clientService, times(1)).isClient();
    }

}