package sda.spring.cars.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import sda.spring.cars.beans.Car;
import sda.spring.cars.beans.Suv;

@Configuration
@PropertySource("application.properties")
public class Config {

    @Value("${carName}")
    private String carName;

    @Bean
    public Car getCar() {
        Car car = new Car();
        car.setName(carName);
        return car;
    }

    @Bean
    Suv getSuv() {
        return new Suv();
    }
}
