package utility;

import java.util.Objects;

public class Car {
    private String registration;
    private String make;
    private String model;
    private String color;
    private int year;



    public Car(String registration) {
        this.registration = registration;
    }

    public Car(String registration, String make, String model, String color, int year) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registration='" + registration + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }


    public boolean isColorEqual(Car car){
        return this.color.equals(car.color);
    }

    public boolean isRegistrationEqual(Car car){
        return this.registration.equals(car.registration);
    }

    public boolean isMakeEqual(Car car){
        return this.make.equals(car.make);
    }

    public boolean isModelEqual(Car car){
        return this.model.equals(car.model);
    }

    public boolean isYearEqual(Car car){
        return this.year==(car.year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && registration.equals(car.registration) && Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registration, make, model, color, year);
    }
}
