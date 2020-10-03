package sda.testing.carrental.model;

public class Car {
    private String brand;
    private String model;
    private Integer year;
    private Float price;

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Car setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public Car setPrice(Float price) {
        this.price = price;
        return this;
    }
}
