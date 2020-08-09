package sda.spring.cars;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sda.spring.cars.beans.Car;
import sda.spring.cars.beans.Suv;
import sda.spring.cars.config.Config;

public class CarsApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.register(Config.class);
        context.refresh();

        Car car = context.getBean(Car.class);
        Suv suv = context.getBean(Suv.class);

        car.drive();
        System.out.println(car.getName());
        suv.drive();
    }

}
