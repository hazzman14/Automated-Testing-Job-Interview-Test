package tests.unit;

import org.junit.Test;
import utility.Car;
import static org.junit.Assert.*;
public class CarClassTest {

    @Test
    public void testGetRegistration(){
        Car car = new Car("KT17DLX");
        assertEquals(car.getRegistration(),"KT17DLX");
    }

    @Test
    public void testSetRegistration(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        car.setRegistration("DN09HRM");
        assertEquals(car.getRegistration(),"DN09HRM");
    }

    @Test
    public void testGetMake(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        assertEquals(car.getMake(),"Skoda");
    }

    @Test
    public void testSetMake(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        car.setMake("BMW");
        assertEquals(car.getMake(),"BMW");
    }

    @Test
    public void testGetModel(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        assertEquals(car.getModel(),"Superb Sportline Tdi S-A");
    }

    @Test
    public void testSetModel(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        car.setModel("320D");
        assertEquals(car.getModel(),"320D");
    }

    @Test
    public void testGetColor(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        assertEquals(car.getColor(),"White");
    }

    @Test
    public void testSetColor(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        car.setColor("Black");
        assertEquals(car.getColor(),"Black");
    }

    @Test
    public void testGetYear(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        assertEquals(car.getYear(),2017);
    }

    @Test
    public void testSetYear(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        car.setYear(2009);
        assertEquals(car.getYear(),2009);
    }



}
