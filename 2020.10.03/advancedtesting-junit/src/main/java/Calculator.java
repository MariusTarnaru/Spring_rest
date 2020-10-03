package main.java;

public class Calculator<T extends Number> {

    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divide by 0");
        }
        return a / b;
    }

    public double reverseSign(double a) {
        return (-1) * a;
    }

}