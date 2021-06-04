package tests.unit;

import org.junit.Test;
import utility.Car;
import static org.junit.Assert.*;
public class CarTest {

    @Test
    public void testGetRegistration(){
        Car car = new Car("KT17DLX");
        assertEquals(car.getRegistration(),"KT17DLX");
    }

    @Test
    public void testGetMake(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        assertEquals(car.getMake(),"Skoda");
    }

    @Test
    public void testGetColor(){
        Car car = new Car("KT17DLX","Skoda","Superb Sportline Tdi S-A","White",2017);
        assertEquals(car.getColor(),"White");
    }



}
